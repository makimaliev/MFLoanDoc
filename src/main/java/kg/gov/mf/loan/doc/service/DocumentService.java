package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentService extends GenericService<Document>
{
    List<Document> getDocuments(String documentType);
    List<Document> getDocumentsSenderExecutor(Long userId);
    List<Document> getDocumentsSenderResponsible(Long userId);
    List<Document> getDocumentsReceiverExecutor(Long userId);
    List<Document> getDocumentsReceiverResponsible(Long userId);
}
