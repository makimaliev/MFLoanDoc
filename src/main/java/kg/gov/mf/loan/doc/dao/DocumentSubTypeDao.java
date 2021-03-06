package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentSubType;
import kg.gov.mf.loan.task.dao.GenericDao;

import java.util.List;

public interface DocumentSubTypeDao extends GenericDao<DocumentSubType>
{
    DocumentSubType getByInternalName(String internalName);
    List<DocumentSubType> getByDocumentType(long id);
}