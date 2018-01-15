package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.Information;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="df_document")
public class SenderData extends GenericModel {

    @Column(name = "sd_registeredNumber")
    private String registeredNumber;

    private Long senderStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "sd_registeredDate")
    private Date registeredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "sd_dueDate")
    private Date dueDate;

    @ManyToOne(targetEntity=Responsible.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "sd_responsible")
    private Responsible responsible;

    @ManyToOne(targetEntity=Executor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "sd_executor")
    private Executor executor;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "sd_information")
    private Information information;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "sd_dispatchData")
    private DispatchData dispatchData;

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(Long senderStatus) {
        this.senderStatus = senderStatus;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public DispatchData getDispatchData() {
        return dispatchData;
    }

    public void setDispatchData(DispatchData dispatchData) {
        this.dispatchData = dispatchData;
    }
}
