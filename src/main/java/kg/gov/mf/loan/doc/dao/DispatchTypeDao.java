package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.core.dao.GenericDao;
import kg.gov.mf.loan.doc.model.DispatchType;

public interface DispatchTypeDao extends GenericDao<DispatchType> {

    DispatchType getByInternalName(String internalName);
}
