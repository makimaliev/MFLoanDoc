package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.DocumentType;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentTypeDaoImpl extends GenericDaoImpl<DocumentType> implements DocumentTypeDao
{
    @Override
    public DocumentType getByInternalName(String internalName) {
        return (DocumentType)entityManager.createQuery("Select d from DocumentType d where d.internalName = :internalName")
                .setParameter("internalName", internalName)
                .getResultList()
                .get(0);
    }
}