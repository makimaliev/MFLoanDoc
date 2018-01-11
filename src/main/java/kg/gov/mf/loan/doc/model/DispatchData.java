package kg.gov.mf.loan.doc.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cat_dispatch_data")
public class DispatchData extends Catalog {

    private String description;
    private boolean isParent;
    private Long dispatchBy;
    private Long dispatchTo;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dispatchInitTime = new Date();

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dispatchResponseTime = new Date();

    @ManyToOne(targetEntity=DispatchType.class, fetch = FetchType.EAGER)
    @JoinColumn(name="dispatchType_id")
    private DispatchType dispatchType;

    @ManyToOne(targetEntity=DispatchResult.class, fetch = FetchType.EAGER)
    @JoinColumn(name="dispatchResult_id")
    private DispatchResult dispatchResult;

    @ManyToOne(targetEntity=DispatchTemplate.class, fetch = FetchType.EAGER)
    @JoinColumn(name="dispatchTemplate_id")
    private DispatchTemplate dispatchTemplate;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name="dispatchData_id")
    private DispatchData dispatchData;

    public Date getDispatchInitTime() {
        return dispatchInitTime;
    }

    public void setDispatchInitTime(Date dispatchInitTime) {
        this.dispatchInitTime = dispatchInitTime;
    }

    public Long getDispatchBy() {
        return dispatchBy;
    }

    public void setDispatchBy(Long dispatchBy) {
        this.dispatchBy = dispatchBy;
    }

    public Long getDispatchTo() {
        return dispatchTo;
    }

    public void setDispatchTo(Long dispatchTo) {
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
}
