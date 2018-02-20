package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class DocumentTypeDaoImpl extends GenericDaoImpl<DocumentType> implements DocumentTypeDao
{
    @Override
    public DocumentType getByInternalName(String internalName) {
        List<DocumentType> dt = getCurrentSession().createQuery(" from DocumentType where internalName = :internalName")
                .setParameter("internalName", internalName)
                .list();
        return dt.get(0);
    }
}