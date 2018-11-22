package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.admin.sys.dao.UserDao;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import kg.gov.mf.loan.doc.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List getDocuments(String documentType, Long userId) {
        return entityManager.createQuery("Select d from Document d where d.owner = :owner and d.documentType = :documentType")
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .setParameter("owner", userId)
                .getResultList();
    }

    @Override
    public List getInvolvedDocuments(String documentType, Long userId) {
        return entityManager.createQuery("Select d from Document d join d.users u where u in (:usr) and d.documentType = :documentType")
                .setParameter("documentType", documentTypeDao.getByInternalName(documentType))
                .setParameter("usr", userDao.findById(userId))
                .getResultList();
    }
}
