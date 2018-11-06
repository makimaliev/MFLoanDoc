package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.core.service.GenericService;
import kg.gov.mf.loan.doc.model.Counter;

public interface CounterService extends GenericService<Counter>
{
    Counter getByDepartment(Long department);
    void updateIncoming(Long department);
    void updateOutgoing(Long department);
}
