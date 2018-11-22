package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.DispatchType;
import org.springframework.stereotype.Repository;

@Repository
public class DispatchTypeDaoImpl extends GenericDaoImpl<DispatchType> implements DispatchTypeDao {

    @Override
    public DispatchType getByInternalName(String internalName) {
        return (DispatchType)entityManager.createQuery("Select d from DispatchType d where d.internalName = :internalName")
                .setParameter("internalName", internalName)
                .getResultList()
                .get(0);
    }
}
