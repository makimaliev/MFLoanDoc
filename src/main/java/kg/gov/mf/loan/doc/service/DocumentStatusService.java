package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DocumentStatus;

public interface DocumentStatusService extends GenericService<DocumentStatus>
{
    DocumentStatus getByInternalName(String internalName);
}
