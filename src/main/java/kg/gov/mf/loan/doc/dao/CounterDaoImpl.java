package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao
{
    @Override
    public Counter getByDepartment(Long department) {
        String query = "from Counter where department = :department";
        return (Counter)getCurrentSession().createQuery(query)
                .setParameter("department", department)
                .uniqueResult();
    }
}
