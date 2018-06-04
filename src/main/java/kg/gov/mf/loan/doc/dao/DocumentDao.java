package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List getDocuments(String documentType, Long userId);
    List getArchivedDocuments(Long userId);
    List getInvolvedDocuments(Long userId);
}
