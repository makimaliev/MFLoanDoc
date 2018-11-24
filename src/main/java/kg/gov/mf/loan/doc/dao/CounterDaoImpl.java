package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao
{
    @Override
    public Counter getByDepartment(long department) {
        Counter counter;

        try {
            counter = (Counter) entityManager.createQuery("Select c from Counter c where c.department = :department")
                    .setParameter("department", department)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            counter = new Counter();
            counter.setDepartment(department);
            counter.setIncoming(1);
            counter.setOutgoing(1);
            //entityManager.persist(counter);
            entityManager.merge(counter);
        }
        return counter;
    }
}
