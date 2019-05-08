package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.task.service.GenericService;

import java.util.List;

public interface DispatchDataService extends GenericService<DispatchData> {

    List<DispatchData> getByDocumentId(Long id);
}
