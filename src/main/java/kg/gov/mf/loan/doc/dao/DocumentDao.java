package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Document;
import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List<Document> internalDocuments();
    List<Document> incomingDocuments();
    List<Document> outgoingDocuments();
    List<Document> archivedDocuments();
}
