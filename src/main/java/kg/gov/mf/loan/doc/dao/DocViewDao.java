package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.DataTableResult;
import kg.gov.mf.loan.doc.model.DocView;
import org.springframework.data.jpa.datatables.mapping.Column;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository()
public class DocViewDao {

    @PersistenceContext
    protected EntityManager entityManager;

    public DataTableResult list(long documentType, long userId, DataTablesInput input)
    {
        String selectQuery = "SELECT * FROM documentview  WHERE documentType = " + documentType + " AND FIND_IN_SET('" + userId + "', users)";
        String countQuery = "SELECT count(1) FROM documentview WHERE documentType = " + documentType + " AND FIND_IN_SET('" + userId + "', users)";
        String q = "";

        String columnToSort = input.getColumns().get(input.getOrder().get(0).getColumn()).getName();
        String sortDirection = input.getOrder().get(0).getDir();

        for(Column column : input.getColumns())
        {
            if(!column.getSearch().getValue().isEmpty()) {
                if(column.getName().contains("Date"))
                {
                    q += " and (date(" + column.getName() + ") between :" + column.getName() + "fd and :" + column.getName() + "td)";
                }
                else
                {
                    q += " and cast(" + column.getName() + " as char) like :" + column.getName();
                }
            }
        }

        q += " order by " + columnToSort + " " + sortDirection;

        Query querySelect = entityManager.createNativeQuery(selectQuery + q, DocView.class);
        Query queryCount = entityManager.createNativeQuery(countQuery + q);

        for(Column column : input.getColumns())
        {
            if(!column.getSearch().getValue().isEmpty()) {
                if(column.getName().contains("Date"))
                {
                    Date[] dates = getDates(column.getSearch().getValue());
                    querySelect.setParameter(column.getName() + "fd", dates[0]);
                    querySelect.setParameter(column.getName() + "td", dates[1]);
                    queryCount.setParameter(column.getName() + "fd", dates[0]);
                    queryCount.setParameter(column.getName() + "td", dates[1]);
                }
                else
                {
                    querySelect.setParameter(column.getName(), "%" + column.getSearch().getValue() + "%");
                    queryCount.setParameter(column.getName(), "%" + column.getSearch().getValue() + "%");
                }
            }
        }

        DataTableResult dataTableResult = new DataTableResult();
        dataTableResult.setCount(((BigInteger)queryCount
                .getSingleResult()).longValue());
        dataTableResult.setData(
                querySelect
                        .setFirstResult(input.getStart())
                        .setMaxResults(input.getLength())
                        .getResultList()
        );

        return dataTableResult;
    }

    public int count(long documentType)
    {
        String q = "Select count(d.id) from DocView d where d.documentType = " + documentType;
        Long count = (Long)entityManager.createQuery(q)
                .getSingleResult();

        return count.intValue();
    }

    private Date[] getDates(String dates)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");

        String[] allDate = dates.split("-");

        String fd = allDate[0].replaceAll("\\s+","");
        String td = allDate[1].replaceAll("\\s+","");

        Date[] d = new Date[2];

        try {
            d[0] = format.parse(fd);
            d[1] = format.parse(td);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
