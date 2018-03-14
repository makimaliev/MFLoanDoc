package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DocumentStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentStatusDaoImpl extends GenericDaoImpl<DocumentStatus> implements DocumentStatusDao
{
    @Override
    public DocumentStatus getByInternalName(String internalName) {
        List<DocumentStatus> dst = getCurrentSession().createQuery(" from DocumentStatus where internalName = :internalName")
                .setParameter("internalName", internalName)
                .list();
        return dst.get(0);
    }
}
