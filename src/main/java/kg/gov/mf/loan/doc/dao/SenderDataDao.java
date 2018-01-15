package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.SenderData;
import org.springframework.stereotype.Repository;

@Repository
public class SenderDataDao extends GenericDaoImpl<SenderData>
{
    @Override
    public void deleteById(SenderData senderData)
    {
        senderData.setRegisteredNumber(null);
        senderData.setSenderStatus(null);
        senderData.setRegisteredDate(null);
        senderData.setDueDate(null);
        senderData.setResponsible(null);
        senderData.setExecutor(null);
        senderData.setInformation(null);
        senderData.setDispatchData(null);
        getCurrentSession().update(senderData);
    }
}