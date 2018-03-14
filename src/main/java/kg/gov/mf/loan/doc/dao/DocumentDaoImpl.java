package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.DocumentType;
import kg.gov.mf.loan.doc.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao
{
    @Autowired
    DocumentTypeDao documentTypeDao;

    @Override
    public List<Document> getDocuments(String documentType) {
        List<Document> documents = getCurrentSession().createQuery(" from Document where documentType = :documentType")
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .list();
        return documents;
    }

    @Override
    public List<Document> getDocumentsSenderExecutor(Long userId) {
        return null;
    }

    @Override
    public List<Document> getDocumentsSenderResponsible(Long userId) {
        return null;
    }

    @Override
    public List<Document> getDocumentsReceiverResponsible(Long userId) {
        return null;
    }

    @Override
    public List<Document> getDocumentsReceiverExecutor(Long userId) {
        return null;
    }
}
