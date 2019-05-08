package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.task.dao.GenericDao;

import java.util.List;

public interface DispatchDataDao extends GenericDao<DispatchData> {

    List<DispatchData> getByDocumentId(Long id);

}
