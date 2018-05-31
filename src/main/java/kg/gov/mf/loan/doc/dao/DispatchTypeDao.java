package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DispatchType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface DispatchTypeDao extends GenericDao<DispatchType> {

    DispatchType getByInternalName(String internalName);
}
