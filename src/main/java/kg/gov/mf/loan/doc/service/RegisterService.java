package kg.gov.mf.loan.doc.service;

public interface RegisterService
{
    String generateRegistrationNumber();
    String generateInternalRegistrationNumber();
    String generateIncomingRegistrationNumber();
    String generateOutgoingRegistrationNumber();
    String generateArchiveRegistrationNumber();
}
