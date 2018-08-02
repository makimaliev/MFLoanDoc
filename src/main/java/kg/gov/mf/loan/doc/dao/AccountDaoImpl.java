package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao
{
    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccounts(String internalName)
    {
        List<Account> accounts = getCurrentSession().createQuery(" from Account where internalName = :internalName")
                .setParameter("internalName", internalName)
                .list();
        return accounts;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> getByName(String internalName, String name)
    {
        List<Account> accounts = getCurrentSession().createQuery(" from Account where internalName = :internalName AND name LIKE :name")
                .setParameter("internalName", internalName)
                .setParameter("name", "%" + name + "%")
                .list();
        return accounts;
    }
}
