package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.DocumentStatus;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentStatusDaoImpl extends GenericDaoImpl<DocumentStatus> implements DocumentStatusDao
{
    @Override
    public DocumentStatus getByInternalName(String internalName) {
        return (DocumentStatus)entityManager.createQuery("Select d from DocumentStatus d where d.internalName = :internalName")
                .setParameter("internalName", internalName)
                .getResultList()
                .get(0);
    }
}
