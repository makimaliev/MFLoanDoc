package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.admin.sys.service.UserService;
import kg.gov.mf.loan.doc.dao.CounterDao;
import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.State;
import kg.gov.mf.loan.task.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class CounterServiceImpl extends GenericServiceImpl<Counter> implements CounterService
{
    private CounterDao dao;
    private UserService userService;
    private DocumentService documentService;

    @Autowired
    public CounterServiceImpl(CounterDao dao, UserService userService, DocumentService documentService) {
        this.userService = userService;
        this.dao = dao;
        this.documentService = documentService;
    }

    @Override
    public Long getNumber() {
        return dao.getNumber();
    }

    @Override
    public String generateRegistrationNumber(Document document) {

        User user = userService.findById(document.getOwner().getId());

        Counter counter;
        long department = user.getStaff().getDepartment().getId();
        long documentType = document.getDocumentType().getId();
        long documentSubType = document.getDocumentSubType().getId();
        long c;

        if (document.getDocumentType().getInternalName().equals("incoming"))
        {
            counter = getCounter(0, 0,0);
            c = counter.getIncoming();
            updateIncoming(counter);
        }
        else if(document.getDocumentType().getInternalName().equals("outgoing"))
        {
            counter = getCounter(0, 0, 0);
            c = counter.getOutgoing();
            updateOutgoing(counter);
        }
        else if(document.getDocumentType().getInternalName().equals("internal"))
        {
            if(document.getDocumentState() == State.REQUESTED) {
                counter = getCounter(department, documentType,0);
                c = counter.getOutgoing();
                updateOutgoing(counter);
            }
            else {
                counter = getCounter(department, documentType,0);
                c = counter.getIncoming();
                updateIncoming(counter);
            }
        }
        else
        {
            counter = getCounter(department, documentType, documentSubType);
            c = counter.getOutgoing();
            updateOutgoing(counter);
        }
        document.setDocIndex(c);
        documentService.update(document);

        /*
        {No} - Номер документа
        {ВД} - Вид документа
        {ТД} - Тип документа
        {КО} - Код организации
        {КС} - Код сотрудника
        {ДД} - День (две цифры)
        {ММ} - Месяц (две цифры)
        {ГГ} - Год (две цифры)
        {ГГГГ} - Год (четыре цифры)
        */

        Date date = new Date();
        DecimalFormat dFormat= new DecimalFormat("00");

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        String day = dFormat.format(cal.get(Calendar.DAY_OF_MONTH));
        String month = dFormat.format(cal.get(Calendar.MONTH) + 1);
        String year = String.valueOf(cal.get(Calendar.YEAR));

        Map<String, String> fmt = new HashMap<>();
        fmt.put("No", String.valueOf(c));
        fmt.put("ВД", document.getDocumentType().getCode());
        fmt.put("ТД", document.getDocumentSubType().getCode());
        fmt.put("КО", Objects.toString(user.getStaff().getDepartment().getDescription(), ""));
        fmt.put("КС", String.valueOf(user.getId()));
        fmt.put("ДД", day);
        fmt.put("ММ", month);
        fmt.put("ГГ", year.substring(2));
        fmt.put("ГГГГ", year);

        String format = document.getDocumentType().getRegNoFormat();

        for(Map.Entry<String, String> entry : fmt.entrySet())
        {
            Pattern pattern = Pattern.compile("\\{" + entry.getKey() + "(.*?)}");
            Matcher matcher = pattern.matcher(format);

            if(matcher.find())
            {
                String index = matcher.group().replaceAll("\\D+", "");
                String value = !index.isEmpty() ? String.format("%0" + index + "d", Integer.valueOf(entry.getValue())) : entry.getValue();
                format = format.replace(matcher.group(), value);
            }
        }

        return format;
    }

    public Counter getCounter(long department, long documentType, long documentSubType) {
        return dao.getCounter(department, documentType, documentSubType);
    }

    private void updateIncoming(Counter counter) {
        counter.setIncoming(counter.getIncoming() + 1);
        dao.update(counter);
    }

    private void updateOutgoing(Counter counter) {
        counter.setOutgoing(counter.getOutgoing() + 1);
        dao.update(counter);
    }
}
