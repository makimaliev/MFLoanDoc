package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.admin.sys.dao.UserDao;
import kg.gov.mf.loan.doc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao
{
    private DocumentTypeDao documentTypeDao;
    private UserDao userDao;

    @Autowired
    public DocumentDaoImpl(DocumentTypeDao documentTypeDao, UserDao userDao) {
        this.documentTypeDao = documentTypeDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List getDocuments(String documentType, Long userId) {
        String query = "from Document d where owner = :owner and d.documentType = :documentType and archived = false";
        return getCurrentSession().createQuery(query)
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .setParameter("owner", userId)
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document>  getArchivedDocuments(Long userId) {
        String query = "from Document where owner = :owner and archived = true";
        return getCurrentSession().createQuery(query)
                .setParameter("owner", userId)
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document> getInvolvedDocuments(String documentType, Long userId) {
        String query = "Select d from Document d join d.users u where u in (:usr) and d.documentType = :documentType";
        return getCurrentSession().createQuery(query)
                .setParameter("usr", userDao.findById(userId))
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .list();
    }
}
