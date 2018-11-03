package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao
{
    @Override
    public Counter getByDepartment(Long department) {
        return (Counter)entityManager.createQuery("Select c from Counter c where c.department = :department")
                .setParameter("department", department)
                .getSingleResult();
    }
}
