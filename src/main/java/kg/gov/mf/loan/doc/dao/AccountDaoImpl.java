package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Account;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao
{
    @Override
    public List<Account> getAccounts(Long atype)
    {
        List<Account> accounts = getCurrentSession().createQuery(" from Account where atype = :atype")
                .setParameter("atype", atype)
                .list();
        return accounts;
    }
}
