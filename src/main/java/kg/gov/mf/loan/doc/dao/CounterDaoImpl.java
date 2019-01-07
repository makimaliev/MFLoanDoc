package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao
{
    @Override
    public Counter getCounter(long department, long documentSubType) {

        Counter counter;

        try {
            counter = (Counter) entityManager.createQuery("Select c from Counter c where c.department = :department and c.documentSubType = :documentSubType")
                    .setParameter("department", department)
                    .setParameter("documentSubType", documentSubType)
                    .getSingleResult();

            return counter;
        }
        catch (NoResultException nre)
        {
            counter = new Counter();
            counter.setDepartment(department);
            counter.setDocumentSubType(documentSubType);
            counter.setIncoming(1);
            counter.setOutgoing(1);

            return entityManager.merge(counter);
        }
    }
}
