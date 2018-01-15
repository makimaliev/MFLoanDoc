package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class DocumentTypeDaoImpl extends GenericDaoImpl<DocumentType> implements DocumentTypeDao
{
    @Override
    public Long getIdByInternalname(String name) {
        List<DocumentType> dt = getCurrentSession().createQuery("from DocumentType where internalName = :internalName")
                .setParameter("internalName", name)
                .list();
        return dt.get(0).getId();
    }
}