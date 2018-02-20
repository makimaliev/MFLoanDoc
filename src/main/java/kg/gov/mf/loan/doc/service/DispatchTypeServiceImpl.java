package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DispatchTypeDao;
import kg.gov.mf.loan.doc.model.DispatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DispatchTypeServiceImpl extends GenericServiceImpl<DispatchType> implements DispatchTypeService {

    @Autowired
    private DispatchTypeDao dao;

    @Override
    public DispatchType getByInternalName(String internalName) {
        return dao.getByInternalName(internalName);
    }
}
