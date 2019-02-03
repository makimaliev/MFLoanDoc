package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.admin.sys.service.UserService;
import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{

    private CounterService counterService;
    private UserService userService;

    @Autowired
    public RegisterServiceImpl(CounterService counterService, UserService userService) {
        this.counterService = counterService;
        this.userService = userService;
    }

    @Override
    public String generateRegistrationNumber(Document document) {

        Counter counter;
        long c;

        User user = document.getOwner();

        long department = user.getStaff().getDepartment().getId();

        if (document.getDocumentType().getInternalName().equals("incoming"))
        {
            counter = counterService.getCounter(0,0);
            c = counter.getIncoming();
            //counterService.updateIncoming(counter);
        }
        else if(document.getDocumentType().getInternalName().equals("outgoing"))
        {
            counter = counterService.getCounter(department, 0);
            c = counter.getOutgoing();
            //counterService.updateOutgoing(counter);
        }
        else
        {
            if(document.getDocumentState().ordinal() < State.REGISTERED.ordinal()) {
                counter = counterService.getCounter(department, document.getDocumentSubType().getId());
                c = counter.getIncoming();
                counter.setIncoming(c+1);
                //counterService.updateIncoming(counter);
            }
            else
            {
                counter = counterService.getCounter(department, document.getDocumentSubType().getId());
                c = counter.getOutgoing();
                counter.setOutgoing(c+1);
                //counterService.updateOutgoing(counter);
            }
        }

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
}
