package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="cat_dispatch_data")
public class DispatchData extends GenericModel {

    public DispatchData() { }

    private String description;
    private boolean isParent;

    @ManyToOne(optional=false)
    @JoinColumn(name="dispatchBy_id")
    private User dispatchBy;

    @ManyToOne(optional=false)
    @JoinColumn(name="dispatchTo_id")
    private User dispatchTo;

    @Column(columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dispatchInitTime;

    @Column(columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dispatchResponseTime;

    @Enumerated(EnumType.ORDINAL)
    private State dispatchType;

    @ManyToOne
    @JoinColumn(name = "dispatchResult")
    private DispatchResult dispatchResult;

    @ManyToOne
    @JoinColumn(name = "dispatchTemplate")
    private DispatchTemplate dispatchTemplate;

    @ManyToOne
    @JoinColumn(name = "dispatchData")
    private DispatchData dispatchData;

    //region GET-SET
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
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

    public DispatchResult getDispatchResult() {
        return dispatchResult;
    }

    public void setDispatchResult(DispatchResult dispatchResult) {
        this.dispatchResult = dispatchResult;
    }

    public DispatchTemplate getDispatchTemplate() {
        return dispatchTemplate;
    }

    public void setDispatchTemplate(DispatchTemplate dispatchTemplate) {
        this.dispatchTemplate = dispatchTemplate;
    }

    public DispatchData getDispatchData() {
        return dispatchData;
    }

    public void setDispatchData(DispatchData dispatchData) {
        this.dispatchData = dispatchData;
    }
    //endregion
}
