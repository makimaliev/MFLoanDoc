package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DispatchType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DispatchTypeDaoImpl extends GenericDaoImpl<DispatchType> implements DispatchTypeDao {

    @Override
    @Transactional(readOnly = true)
    public DispatchType getByInternalName(String internalName) {
        List<DispatchType> dst = getCurrentSession().createQuery(" from DispatchType where internalName = :internalName")
                .setParameter("internalName", internalName)
                .list();
        return dst.get(0);
    }
}
