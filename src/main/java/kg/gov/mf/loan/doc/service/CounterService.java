package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.service.GenericService;

public interface CounterService extends GenericService<Counter>
{
    Counter getByDepartment(Long department);
    void updateIncoming(Long department);
    void updateOutgoing(Long department);
}
