package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.task.service.GenericService;
import kg.gov.mf.loan.doc.model.Counter;

public interface CounterService extends GenericService<Counter>
{
    Counter getByDepartment(long department);
    void updateIncoming(long department);
    void updateOutgoing(long department);
}
