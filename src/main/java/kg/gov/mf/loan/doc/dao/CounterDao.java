package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.dao.GenericDao;
import kg.gov.mf.loan.doc.model.Counter;

public interface CounterDao  extends GenericDao<Counter>
{
    Counter getByDepartment(Long department);
}
