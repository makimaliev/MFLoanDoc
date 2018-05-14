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
        List document;
        String query = "Select d from Document d join d.users u where u in (:users) and d.documentType = :documentType and documentState < 8";
        document = getCurrentSession().createQuery(query)
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .setParameter("users", userDao.findById(userId))
                .list();
        return document;
    }

    @Override
    @Transactional(readOnly = true)
    public List getArchivedDocuments(Long userId) {
        List document;
        String query = "Select d from Document d join d.users u where u in (:users) and documentState = 8";
        document = getCurrentSession().createQuery(query)
                .setParameter("users", userDao.findById(userId))
                .list();
        return document;
    }
}
