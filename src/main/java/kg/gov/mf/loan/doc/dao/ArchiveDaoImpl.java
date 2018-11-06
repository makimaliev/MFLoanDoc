package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.core.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.Archive;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArchiveDaoImpl extends GenericDaoImpl<Archive> implements ArchiveDao {

    @Override
    public Archive findByIdWD(Long id) {
        return entityManager.find(Archive.class, id);
    }

    @Override
    public List findAllWD() {
        return entityManager.createQuery("Select a from Archive a JOIN FETCH a.attachments")
                .getResultList();
                //.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
    }
}
