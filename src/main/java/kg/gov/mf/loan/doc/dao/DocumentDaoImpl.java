package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.admin.sys.dao.UserDao;
import kg.gov.mf.loan.doc.model.DataTableResult;
import kg.gov.mf.loan.doc.model.Document;
import kg.gov.mf.loan.doc.model.DocumentType;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDao
{
    private UserDao userDao;

    @Autowired
    public DocumentDaoImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List searchOutgoingDocuments(String documentNo) {

        List list = entityManager.createQuery("Select d from Document d where d.documentType.internalName = 'outgoing' and d.senderRegisteredNumber like :documentNo order by d.id asc")
                .setParameter("documentNo", "%"+ documentNo + "%")
                .getResultList();

        return list;
    }

    @Override
    public List getDocuments(long userId, String documentType, String documentSubType) {

        String q = "Select d from Document d";

        q += userId != 0 ? " join d.users u" : "";

        q += " where 1=1";

        q += userId != 0 ? " and u in (:usr)" : "";
        q += documentType != null ? " and d.documentType.internalName = :documentType" : "";
        q += documentSubType != null ? " and d.documentSubType.internalName = :documentSubType" : "";
        q += " order by d.id asc";

        Query query = entityManager.createQuery(q);
        if(userId != 0) {
            query.setParameter("usr", userDao.findById(userId));
        }

        if(documentType != null) {
            query.setParameter("documentType", documentType);
        }

        if(documentSubType != null) {
            query.setParameter("documentSubType", documentSubType);
        }

        return query.getResultList();
    }

    @Override
    public DataTableResult list(String documentType, String documentSubType, long userId, int firstResult, int maxResults, String column, String direction, String[] columns, String searchValue) {

        String selectQuery = "Select d from Document d";
        String countQuery = "Select count(1) from Document d";
        String q = "";

        q += userId != 0 ? " join d.users u " : "";
        q += " where 1=1";
        q += userId != 0 ? " and u in (:usr)" : "";
        q += documentType != null ? " and d.documentType.internalName = :documentType" : "";
        q += documentSubType != null ? " and d.documentSubType.name = :documentSubType" : "";

        if(!searchValue.isEmpty()) {
            q += " and (";
            boolean b = true;
            for (String str : columns)
            {
                if(b) {
                    q += "cast(d." + str + " as string) like :searchValue";
                }
                else {
                    q += " or cast(d." + str + " as string) like :searchValue";
                }
                b = false;
            }
            q += " )";
        }

        q += column != null ? " order by d." + column + " " + direction : " order by d.id " + direction;

        Query querySelect = entityManager.createQuery(selectQuery + q);
        Query queryCount = entityManager.createQuery(countQuery + q);

        if(userId != 0) {
            querySelect.setParameter("usr", userDao.findById(userId));
            queryCount.setParameter("usr", userDao.findById(userId));
        }

        if(documentType != null) {
            querySelect.setParameter("documentType", documentType);
            queryCount.setParameter("documentType", documentType);
        }

        if(documentSubType != null) {
            querySelect.setParameter("documentSubType", documentSubType);
            queryCount.setParameter("documentSubType", documentSubType);
        }

        if(!searchValue.isEmpty()) {
            querySelect.setParameter("searchValue", "%" + searchValue + "%");
            queryCount.setParameter("searchValue", "%" + searchValue + "%");
        }


        DataTableResult dataTableResult = new DataTableResult();
        dataTableResult.setCount((Long)queryCount.getSingleResult());
        dataTableResult.setData(
                querySelect
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList()
        );

        return dataTableResult;
    }

    @Override
    public int count(String documentType) {

        String q = "Select count(d.id) from Document d where d.documentType.internalName = :documentType";
        Long count = (Long)entityManager.createQuery(q)
                .setParameter("documentType", documentType)
                .getSingleResult();

        return count.intValue();
    }

    private CriteriaQuery<Document> criteria(String column, String direction, DocumentType documentType) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> criteria = builder.createQuery(Document.class);
        //criteria.

        Root<Document> root = criteria.from(Document.class);
        criteria.select(root)
                .distinct(true);

        if(direction.equals("asc"))
        {
            criteria.orderBy(builder.asc(root.get(column)));
        }
        else
        {
            criteria.orderBy(builder.desc(root.get(column)));
        }

        return criteria;
    }
}
