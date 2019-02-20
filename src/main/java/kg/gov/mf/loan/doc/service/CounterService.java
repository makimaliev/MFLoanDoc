package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Counter;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.task.service.GenericService;

public interface CounterService extends GenericService<Counter>
{
    Counter getCounter(long department, long documentType, long documentSubType);
    Long getNumber();
    String generateRegistrationNumber(Document document, long userId);
}
