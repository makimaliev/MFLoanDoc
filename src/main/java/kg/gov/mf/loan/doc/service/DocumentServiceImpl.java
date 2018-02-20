package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DocumentDao;
import kg.gov.mf.loan.doc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentServiceImpl extends GenericServiceImpl<Document> implements DocumentService
{
    @Autowired
    private DocumentDao dao;

    @Override
    public List<Document> getDocuments(String documentType) {
        return dao.getDocuments(documentType);
    }
}
