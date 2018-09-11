package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.doc.dao.CounterDao;
import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl extends GenericServiceImpl<Counter> implements CounterService
{
    @Autowired
    private CounterDao dao;

    @Override
    public Counter getByDepartment(Long department) {
        return dao.getByDepartment(department);
    }

    @Override
    public void updateIncoming(Long department)
    {
        Counter counter = dao.getByDepartment(department);
        Long incoming = counter.getIncoming();
        counter.setIncoming(++incoming);

        dao.edit(counter);
    }

    @Override
    public void updateOutgoing(Long department)
    {
        Counter counter = dao.getByDepartment(department);
        Long outgoing = counter.getOutgoing();
        counter.setIncoming(++outgoing);

        dao.edit(counter);
    }
}
