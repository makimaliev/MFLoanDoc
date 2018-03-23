package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.AccountDao;
import kg.gov.mf.loan.doc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Account> implements AccountService
{
    @Autowired
    private AccountDao dao;

    @Override
    public List<Account> getOrganizations() {
        return dao.getAccounts(1L);
    }

    @Override
    public List<Account> getDepartments() {
        return dao.getAccounts(2L);
    }

    @Override
    public List<Account> getStaff() {
        return dao.getAccounts(3L);
    }

    @Override
    public List<Account> getPerson() {
        return dao.getAccounts(4L);
    }
}
