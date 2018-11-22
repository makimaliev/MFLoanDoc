package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.task.dao.GenericDao;
import kg.gov.mf.loan.doc.model.DocumentStatus;

public interface DocumentStatusDao extends GenericDao<DocumentStatus>
{
    DocumentStatus getByInternalName(String internalName);
}
