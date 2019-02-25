package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DataTableResult;
import kg.gov.mf.loan.doc.model.DocumentType;
import kg.gov.mf.loan.task.service.GenericService;
import kg.gov.mf.loan.doc.model.Document;

import java.util.List;

public interface DocumentService extends GenericService<Document>
{
    List searchOutgoingDocuments(String documentNo);
    int count(String documentType);
    DataTableResult list(String documentType, String documentSubType, long userId, int firstResult, int maxResults, String column, String direction, String[] columns, String searchValue);
    List<Document> getDocuments(long userId, String documentType, String documentSubType);

    Document create(Document document, String action);
    Document request(Document document, String action);
    Document reconcile(Document document, String action);
    Document approve(Document document, String action);
    Document reject(Document document, String action);
    Document register(Document document, String action);
    Document accept(Document document, String action);
    Document send(Document document, String action);
    Document start(Document document, String action);
    Document finish(Document document, String action);
}
