package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Account;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao
{
    @Override
    public List getAccounts(String internalName) {

        return entityManager.createQuery("Select a from Account a where a.internalName = :internalName order by a.name")
                .setParameter("internalName", internalName)
                .getResultList();
    }

    @Override
    public List getByName(String internalName, String name) {

        return entityManager.createQuery("Select a from Account a where a.internalName = :internalName AND a.name LIKE :name order by a.name")
                .setParameter("internalName", internalName)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
