package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DocumentStatus;
import kg.gov.mf.loan.task.service.GenericService;

public interface DocumentStatusService extends GenericService<DocumentStatus>
{
    DocumentStatus getByInternalName(String internalName);
}
