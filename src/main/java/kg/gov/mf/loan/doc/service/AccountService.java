package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.core.service.GenericService;
import kg.gov.mf.loan.doc.model.Account;

import java.util.List;

public interface AccountService extends GenericService<Account>
{
    List<Account> getOrganizations();
    List<Account> getDepartments();
    List<Account> getStaff();
    List<Account> getPerson();
    List<Account> getByName(String internalName, String name);
}
