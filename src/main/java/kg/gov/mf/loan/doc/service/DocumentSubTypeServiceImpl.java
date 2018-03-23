package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DocumentSubTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.gov.mf.loan.doc.model.DocumentSubType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentSubTypeServiceImpl extends GenericServiceImpl<DocumentSubType> implements DocumentSubTypeService
{
    @Autowired
    private DocumentSubTypeDao dao;

    @Override
    public DocumentSubType getByInternalName(String internalName) {
        return dao.getByInternalName(internalName);
    }

    @Override
    public List<DocumentSubType> getByDocumentType(Long id) {
        return dao.getByDocumentType(id);
    }
}
