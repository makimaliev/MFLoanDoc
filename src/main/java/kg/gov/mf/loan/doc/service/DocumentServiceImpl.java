package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.task.service.GenericServiceImpl;
import kg.gov.mf.loan.doc.dao.DocumentDao;
import kg.gov.mf.loan.doc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl extends GenericServiceImpl<Document> implements DocumentService
{
    private DocumentDao dao;

    @Autowired
    public DocumentServiceImpl(DocumentDao dao) {
        this.dao = dao;
     }

    @Override
    public List<Document> getDocuments(long userId) {
        return dao.getDocuments(userId);
    }

    @Override
    public List<Document> getInvolvedDocuments(String documentType, long userId) {
        return dao.getInvolvedDocuments(documentType, userId);
    }

    @Override
    public Document create(Document document, String action) {
        return null;
    }

    @Override
    public Document request(Document document, String action) {
        return null;
    }

    @Override
    public Document reconcile(Document document, String action) {
        return null;
    }

    @Override
    public Document approve(Document document, String action) {
        return null;
    }

    @Override
    public Document reject(Document document, String action) {
        return null;
    }

    @Override
    public Document register(Document document, String action) {
        return null;
    }

    @Override
    public Document accept(Document document, String action) {
        return null;
    }

    @Override
    public Document send(Document document, String action) {
        return null;
    }

    @Override
    public Document start(Document document, String action) {
        return null;
    }

    @Override
    public Document finish(Document document, String action) {
        return null;
    }
}
