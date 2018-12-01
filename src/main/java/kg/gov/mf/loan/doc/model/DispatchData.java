package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.task.listener.MFEntityListener;
import kg.gov.mf.loan.task.model.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cat_dispatch_data")
public class DispatchData extends GenericModel {

    public DispatchData() { }

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private State dispatchType;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dispatchInitTime;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dispatchResponseTime;

    @ManyToOne
    @JoinColumn(name = "dispatchBy")
    private User dispatchBy;

    @ManyToOne
    @JoinColumn(name = "dispatchTo")
    private User dispatchTo;

    //region GET-SET
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getDispatchBy() {
        return dispatchBy;
    }

    public void setDispatchBy(User dispatchBy) {
        this.dispatchBy = dispatchBy;
    }

    public User getDispatchTo() {
        return dispatchTo;
    }

    public void setDispatchTo(User dispatchTo) {
        this.dispatchTo = dispatchTo;
    }

    public Date getDispatchInitTime() {
        return dispatchInitTime;
    }

    public void setDispatchInitTime(Date dispatchInitTime) {
        this.dispatchInitTime = dispatchInitTime;
    }

    public Date getDispatchResponseTime() {
        return dispatchResponseTime;
    }

    public void setDispatchResponseTime(Date dispatchResponseTime) {
        this.dispatchResponseTime = dispatchResponseTime;
    }

    public State getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(State dispatchType) {
        this.dispatchType = dispatchType;
    }
    //endregion
}
