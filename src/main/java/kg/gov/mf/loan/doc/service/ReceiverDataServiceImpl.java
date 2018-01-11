package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.ReceiverDataDao;
import kg.gov.mf.loan.doc.model.SenderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.gov.mf.loan.doc.model.ReceiverData;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceiverDataServiceImpl extends GenericServiceImpl<ReceiverData> implements ReceiverDataService
{
    /*
    @Autowired
    private ReceiverDataDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ReceiverData getDocumentReceiverData(Long id) {
        return dao.getDocumentReceiverData(id);
    }
    */
}
