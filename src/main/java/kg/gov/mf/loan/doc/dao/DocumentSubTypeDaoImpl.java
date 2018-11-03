package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.DocumentSubType;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DocumentSubTypeDaoImpl extends GenericDaoImpl<DocumentSubType> implements DocumentSubTypeDao
{
    @Override
    public DocumentSubType getByInternalName(String internalName) {
        return (DocumentSubType)entityManager.createQuery("Select d from DocumentSubType d where d.internalName = :internalName")
                .setParameter("internalName", internalName)
                .getResultList()
                .get(0);
    }

    @Override
    public List getByDocumentType(Long id) {
        return entityManager.createQuery("Select d from DocumentSubType d where d.documentType = :documentType")
                .setParameter("documentType", id)
                .getResultList();
    }
}