package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentService extends GenericService<Document>
{
    List<Document> getDocuments(String documentType, Long userId);
    List getArchivedDocuments(Long userId);
}
