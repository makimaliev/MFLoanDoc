package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Account;
import kg.gov.mf.loan.task.dao.GenericDao;

import java.util.List;

public interface AccountDao extends GenericDao<Account>
{
    List<Account> getAccounts(String internalName);
    List<Account> getByName(String internalName, String name);
}
