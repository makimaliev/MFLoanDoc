package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.core.service.GenericServiceImpl;
import kg.gov.mf.loan.doc.dao.CounterDao;
import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

        dao.update(counter);
    }

    @Override
    public void updateOutgoing(Long department)
    {
        Counter counter = dao.getByDepartment(department);
        Long outgoing = counter.getOutgoing();
        counter.setOutgoing(++outgoing);

        dao.update(counter);
    }
}
