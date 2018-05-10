package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentSubType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DocumentSubTypeDaoImpl extends GenericDaoImpl<DocumentSubType> implements DocumentSubTypeDao
{
    @Override
    @Transactional(readOnly = true)
    public DocumentSubType getByInternalName(String internalName) {
        List<DocumentSubType> dst = getCurrentSession().createQuery(" from DocumentSubType where internalName = :internalName")
                .setParameter("internalName", internalName)
                .list();
        return dst.get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentSubType> getByDocumentType(Long id) {
        List<DocumentSubType> dst = getCurrentSession().createQuery(" from DocumentSubType where documentType = :documentType")
                .setParameter("documentType", id)
                .list();
        return dst;
    }
}