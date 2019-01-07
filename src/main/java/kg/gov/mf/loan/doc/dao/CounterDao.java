package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.task.dao.GenericDao;

public interface CounterDao  extends GenericDao<Counter>
{
    Counter getCounter(long department, long documentSubType);
}
