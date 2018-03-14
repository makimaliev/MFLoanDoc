package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List<Document> getDocuments(String documentType);
    List<Document> getDocumentsSenderExecutor(Long userId);
    List<Document> getDocumentsSenderResponsible(Long userId);
    List<Document> getDocumentsReceiverExecutor(Long userId);
    List<Document> getDocumentsReceiverResponsible(Long userId);
}
