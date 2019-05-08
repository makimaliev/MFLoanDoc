package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentStatus;
import kg.gov.mf.loan.task.dao.GenericDao;

public interface DocumentStatusDao extends GenericDao<DocumentStatus>
{
    DocumentStatus getByInternalName(String internalName);
}
