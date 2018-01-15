package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.ReceiverData;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiverDataDao extends GenericDaoImpl<ReceiverData>
{
    @Override
    public void deleteById(ReceiverData receiverData)
    {
        receiverData.setRegisteredNumber(null);
        receiverData.setReceiverStatus(null);
        receiverData.setRegisteredDate(null);
        receiverData.setDueDate(null);
        receiverData.setResponsible(null);
        receiverData.setExecutor(null);
        receiverData.setInformation(null);
        receiverData.setDispatchData(null);
        getCurrentSession().update(receiverData);
    }
}