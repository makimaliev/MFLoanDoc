package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.ResultDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kg.gov.mf.loan.doc.model.ResultData;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultDataServiceImpl extends GenericServiceImpl<ResultData> implements ResultDataService
{
    /*
    @Autowired
    private ResultDataDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ResultData getDocumentResultData(Long id) {
        return dao.getDocumentResultData(id);
    }
    */
}
