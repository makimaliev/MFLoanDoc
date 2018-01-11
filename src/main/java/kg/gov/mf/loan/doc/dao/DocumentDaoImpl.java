package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao
{
    @Override
    public List<Document> internalDocuments() {
        return getCurrentSession().createQuery("from Document where documentType = 1").list();
    }

    @Override
    public List<Document> incomingDocuments() {
        return getCurrentSession().createQuery("from Document where documentType = 2").list();
    }

    @Override
    public List<Document> outgoingDocuments() {
        return getCurrentSession().createQuery("from Document where documentType = 3").list();
    }
}
