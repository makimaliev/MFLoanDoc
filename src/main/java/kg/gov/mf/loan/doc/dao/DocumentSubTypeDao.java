package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentSubType;
import org.springframework.stereotype.Repository;

public interface DocumentSubTypeDao extends GenericDao<DocumentSubType>
{
    DocumentSubType getByInternalName(String internalName);
}