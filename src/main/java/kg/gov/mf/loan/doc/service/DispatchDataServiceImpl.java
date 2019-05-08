package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.DispatchDataDao;
import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.task.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DispatchDataServiceImpl extends GenericServiceImpl<DispatchData> implements DispatchDataService {

    @Autowired
    private DispatchDataDao dao;

    @Override
    public List<DispatchData> getByDocumentId(Long id) {

        return dao.getByDocumentId(id);
    }
}
