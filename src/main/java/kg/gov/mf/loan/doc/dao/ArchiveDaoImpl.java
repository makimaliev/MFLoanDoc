package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Archive;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ArchiveDaoImpl extends GenericDaoImpl<Archive> implements ArchiveDao {

    @Override
    public Archive findByIdWD(Long id) {
        Archive archive = getCurrentSession().get(Archive.class, id);
        archive.getAttachments().size();
        return archive;
    }

    @Override
    public List<Archive> findAllWD() {
        return getCurrentSession().createQuery("from Archive a JOIN FETCH a.attachments")
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
