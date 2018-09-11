package kg.gov.mf.loan.doc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="df_counter")
public class Counter extends GenericModel
{
    private Long department;
    private Long incoming;
    private Long outgoing;

    //region GET-SET
    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public Long getIncoming() {
        return incoming;
    }

    public void setIncoming(Long incoming) {
        this.incoming = incoming;
    }

    public Long getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Long outgoing) {
        this.outgoing = outgoing;
    }
    //endregion
}
