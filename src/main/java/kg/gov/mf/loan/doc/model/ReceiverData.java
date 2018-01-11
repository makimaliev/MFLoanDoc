package kg.gov.mf.loan.doc.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="df_document")
public class ReceiverData extends GenericModel {

    @Column(name = "rd_registeredNumber")
    private String registeredNumber;

    private Long receiverStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "rd_registeredDate")
    private Date registeredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "rd_dueDate")
    private Date dueDate;

    @ManyToOne(targetEntity=Responsible.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "rd_responsible")
    private Responsible responsible;

    @ManyToOne(targetEntity=Executor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "rd_executor")
    private Executor executor;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "rd_information")
    private Information information;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "rd_dispatchData")
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

    public Long getReceiverStatus() {
        return receiverStatus;
    }

    public void setReceiverStatus(Long receiverStatus) {
        this.receiverStatus = receiverStatus;
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
