package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.SenderDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.gov.mf.loan.doc.model.SenderData;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SenderDataServiceImpl extends GenericServiceImpl<SenderData> implements SenderDataService
{
    /*
    @Autowired
    private SenderDataDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public SenderData getDocumentSenderData(Long id) {
        return dao.getDocumentSenderData(id);
    }
    */
}
