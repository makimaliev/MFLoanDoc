package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DocumentTypeDao;
import kg.gov.mf.loan.doc.model.DocumentType;
import kg.gov.mf.loan.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentTypeServiceImpl extends GenericServiceImpl<DocumentType> implements DocumentTypeService
{
    @Autowired
    private DocumentTypeDao dao;

    @Override
    public DocumentType getByInternalName(String internalName) {
        return dao.getByInternalName(internalName);
    }
}
