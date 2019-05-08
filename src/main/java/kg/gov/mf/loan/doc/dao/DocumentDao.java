package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DataTableResult;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.task.dao.GenericDao;

import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List searchOutgoingDocuments(String documentNo);
    List<Document> getDocuments(long userId, String documentType, String documentSubType);
    int count(String documentType);
    DataTableResult list(String documentType, String documentSubType, long userId, int firstResult, int maxResults, String column, String direction, String[] columns, String searchValue);
}
