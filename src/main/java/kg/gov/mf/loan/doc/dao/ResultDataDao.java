package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.ResultData;
import org.springframework.stereotype.Repository;

@Repository
public class ResultDataDao extends GenericDaoImpl<ResultData>
{
    @Override
    public void remove(ResultData resultData)
    {
        resultData.setResultStatus(null);
        resultData.setDescription(null);
        resultData.setClose_date(null);
        resultData.setInformation(null);
        resultData.setResponsible(null);
        getCurrentSession().update(resultData);
    }
}