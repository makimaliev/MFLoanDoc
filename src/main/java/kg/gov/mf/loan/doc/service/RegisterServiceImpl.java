package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.admin.sys.service.UserService;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public String generateRegistrationNumber() {
        return "ДОК-" + new Random().nextInt(100);
    }

    @Override
    public String generateRegistrationNumber(Document document) {

        Long counter;
        User user = userService.findById(document.getOwner());
        String format = document.getDocumentType().getRegNoFormat();

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer day = cal.get(Calendar.DAY_OF_MONTH);
        Integer month = cal.get(Calendar.MONTH);
        Integer year = cal.get(Calendar.YEAR);

        Long department = user.getStaff().getDepartment().getId();

        if (document.getDocumentType().getInternalName().equals("incoming"))
        {
            counter = counterService.getByDepartment(department).getIncoming();
            counterService.updateIncoming(department);
        }
        else if(document.getDocumentType().getInternalName().equals("outgoing"))
        {
            counter = counterService.getByDepartment(department).getOutgoing();
            counterService.updateOutgoing(department);
        }
        else
        {
            if(document.getDocumentState().ordinal() < State.REGISTERED.ordinal()) {
                counter = counterService.getByDepartment(0L).getIncoming();
                counterService.updateIncoming(0L);
            }
            else
            {
                counter = counterService.getByDepartment(0L).getOutgoing();
                counterService.updateOutgoing(0L);
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

        Map<String, String> fmt = new HashMap<>();
        fmt.put("No", String.valueOf(counter));
        fmt.put("ВД", document.getDocumentType().getCode());
        fmt.put("ТД", document.getDocumentSubType().getCode());
        fmt.put("КО", Objects.requireNonNull(user.getStaff().getDepartment().getDescription(), ""));
        fmt.put("КС", String.valueOf(user.getId()));
        fmt.put("ДД", String.valueOf(day));
        fmt.put("ММ", String.valueOf(month));
        fmt.put("ГГ", String.valueOf(year).substring(2));
        fmt.put("ГГГГ", String.valueOf(year));

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
