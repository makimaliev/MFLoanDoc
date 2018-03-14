package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DocumentStatusDao;
import kg.gov.mf.loan.doc.model.DocumentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentStatusServiceImpl extends GenericServiceImpl<DocumentStatus> implements DocumentStatusService
{
    @Autowired
    private DocumentStatusDao dao;

    @Override
    public DocumentStatus getByInternalName(String internalName) {
        return dao.getByInternalName(internalName);
    }
}
