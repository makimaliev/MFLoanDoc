package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentService extends GenericService<Document>
{
    List<Document> getDocuments(String documentType, Long userId);
    List<Document> getArchivedDocuments(Long userId);
    List<Document> getInvolvedDocuments(String documentType, Long userId);

    Document create(Document document, String action);
    Document request(Document document, String action);
    Document approve(Document document, String action);
    Document reject(Document document, String action);
    Document register(Document document, String action);
    Document accept(Document document, String action);
    Document send(Document document, String action);
    Document start(Document document, String action);
    Document finish(Document document, String action);
}
