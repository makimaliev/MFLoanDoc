package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentType;

public interface DocumentTypeDao extends GenericDao<DocumentType>
{
    DocumentType getByInternalName(String internalName);
}
