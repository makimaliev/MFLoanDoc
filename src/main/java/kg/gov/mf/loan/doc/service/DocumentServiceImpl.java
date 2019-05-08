package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DocumentDao;
import kg.gov.mf.loan.doc.model.DataTableResult;
import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.task.service.GenericServiceImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
    public List searchOutgoingDocuments(String documentNo) {
        return dao.searchOutgoingDocuments(documentNo);
    }

    @Override
    public int count(String documentType) {
        return dao.count(documentType);
    }

    @Override
    public DataTableResult list(String documentType, String documentSubType, long userId, int firstResult, int maxResults, String column, String direction, String[] columns, String searchValue) {
        return dao.list(documentType, documentSubType, userId, firstResult, maxResults, column, direction, columns, searchValue);
    }

    @Override
    public List<Document> getDocuments(long userId, String documentType, String documentSubType) {
        return dao.getDocuments(userId, documentType, documentSubType);
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

    @Override
    public Set<Long> getDocumentUsers(Long id) {
        Document doc = dao.getById(id);
        Hibernate.initialize(doc.getUsers());
        return doc.getUsers();
    }

    @Override
    public Set<DispatchData> getDocumentDispatchData(Long id) {
        Document doc = dao.getById(id);
        Hibernate.initialize(doc.getDispatchData());
        return doc.getDispatchData();
    }
}
