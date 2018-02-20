package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cat_dispatch_data")
public class DispatchData extends Catalog {

    public DispatchData() { }

    private String description;
    private boolean isParent;

    @ManyToOne(optional=false)
    @JoinColumn(name="dispatchBy_id")
    private User dispatchBy;

    @ManyToOne(optional=false)
    @JoinColumn(name="dispatchTo_id")
    private User dispatchTo;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dispatchInitTime = new Date();

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dispatchResponseTime;

    @ManyToOne
    @JoinColumn(name = "dispatchType")
    private DispatchType dispatchType;

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
    public Date getDispatchInitTime() {
        return dispatchInitTime;
    }

    public void setDispatchInitTime(Date dispatchInitTime) {
        this.dispatchInitTime = dispatchInitTime;
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

    public Date getDispatchResponseTime() {
        return dispatchResponseTime;
    }

    public void setDispatchResponseTime(Date dispatchResponseTime) {
        this.dispatchResponseTime = dispatchResponseTime;
    }

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

    public DispatchType getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(DispatchType dispatchType) {
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
