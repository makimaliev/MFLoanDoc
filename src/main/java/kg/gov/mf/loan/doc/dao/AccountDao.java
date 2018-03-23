package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Account;

import java.util.List;

public interface AccountDao extends GenericDao<Account>
{
    List<Account> getAccounts(String internalName);
}