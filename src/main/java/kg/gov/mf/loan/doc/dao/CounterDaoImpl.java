package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao
{
    @Override
    public Counter getCounter(long department, long documentType, long documentSubType) {

        Counter counter;

        try {
            counter = (Counter) entityManager.createQuery("Select c from Counter c where c.department = :department and c.documentType = :documentType and c.documentSubType = :documentSubType")
                    .setParameter("department", department)
                    .setParameter("documentType", documentType)
                    .setParameter("documentSubType", documentSubType)
                    .getSingleResult();

            return counter;
        }
        catch (NoResultException nre)
        {
            counter = new Counter();
            counter.setDepartment(department);
            counter.setDocumentType(documentType);
            counter.setDocumentSubType(documentSubType);
            counter.setIncoming(1);
            counter.setOutgoing(1);

            return entityManager.merge(counter);
        }
    }

    @Override
    public Long getIncomingNumber() {

        Counter c = (Counter) entityManager.createQuery("Select c from Counter c where c.documentType = 0 and c.documentSubType = 0 and c.department = 0")
                .getSingleResult();
        return c.getIncoming();
    }

    @Override
    public Long getOutgoingNumber() {

        Counter c = (Counter) entityManager.createQuery("Select c from Counter c where c.documentType = 0 and c.documentSubType = 0 and c.department = 0")
                .getSingleResult();
        return c.getOutgoing();
    }
}
