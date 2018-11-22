package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.task.service.GenericService;
import kg.gov.mf.loan.doc.model.DispatchType;

public interface DispatchTypeService extends GenericService<DispatchType> {

    DispatchType getByInternalName(String internalName);
}
