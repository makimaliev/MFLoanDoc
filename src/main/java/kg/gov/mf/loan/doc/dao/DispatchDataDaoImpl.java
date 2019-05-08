package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DispatchData;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DispatchDataDaoImpl extends GenericDaoImpl<DispatchData> implements DispatchDataDao {

    @Override
    public List<DispatchData> getByDocumentId(Long id) {
        return entityManager.createQuery("select d.dispatchData from Document d where d.id = :id", DispatchData.class)
                .setParameter("id", id)
                .getResultList();
    }
}
