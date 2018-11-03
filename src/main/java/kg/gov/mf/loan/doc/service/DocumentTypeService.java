package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DocumentType;
import kg.gov.mf.loan.service.GenericService;

public interface DocumentTypeService extends GenericService<DocumentType>
{
    DocumentType getByInternalName(String internalName);
}
