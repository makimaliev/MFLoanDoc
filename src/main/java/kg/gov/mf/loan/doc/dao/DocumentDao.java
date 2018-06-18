package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List<Document> getDocuments(String documentType, Long userId);
    List<Document> getArchivedDocuments(Long userId);
    List<Document> getInvolvedDocuments(String documentType, Long userId);
}
