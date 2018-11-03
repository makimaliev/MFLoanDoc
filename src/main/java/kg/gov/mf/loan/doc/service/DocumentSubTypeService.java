package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DocumentSubType;
import kg.gov.mf.loan.service.GenericService;

import java.util.List;

public interface DocumentSubTypeService extends GenericService<DocumentSubType>
{
    DocumentSubType getByInternalName(String internalName);
    List<DocumentSubType> getByDocumentType(Long id);
}
