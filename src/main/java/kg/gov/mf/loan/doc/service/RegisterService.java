package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Document;

public interface RegisterService
{
    String generateRegistrationNumber();
    String generateRegistrationNumber(Document document);
}
