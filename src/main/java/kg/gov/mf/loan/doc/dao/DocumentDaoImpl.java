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
        String query = "from Document d where owner = :owner and d.documentType = :documentType and documentState < 8";
        return getCurrentSession().createQuery(query)
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .setParameter("owner", userDao.findById(userId).getId())
                .list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getArchivedDocuments(Long userId) {
        String query = "from Document where owner = :owner and documentState = 8";
        return getCurrentSession().createQuery(query)
                .setParameter("owner", userDao.findById(userId).getId())
                .list();
    }
}
