package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.Information;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    public Document() {}

    //region Document

    private String title;
    private String description;
    private Long generalStatus;

    @ManyToOne(targetEntity=DocumentType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "documentType")
	private DocumentType documentType;

    @ManyToOne(targetEntity=DocumentSubType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "documentSubType")
	private DocumentSubType documentSubType;

    @ManyToOne(targetEntity=DocumentTemplate.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "documentTemplate")
    private DocumentTemplate documentTemplate;

    //endregion

    //region Sender Data

    private String senderRegisteredNumber;

    private Long senderStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date senderRegisteredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date senderDueDate;


    /*
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="SENDER_RESPONSIBLE",
            joinColumns = @JoinColumn(name="document_id"),
            inverseJoinColumns = @JoinColumn(name="responsible_id"))
    @Transient
    private Responsible senderResponsible = new Responsible();


*/


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="sender_responsible_id")
    private Responsible senderResponsible;



    @ManyToOne(targetEntity=Executor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderExecutor")
    private Executor senderExecutor;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderInformation")
    private Information senderInformation;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderDispatchData")
    private DispatchData senderDispatchData;

    //endregion

    //region Receiver Data
    private String receiverRegisteredNumber;

    private Long receiverStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date receiverRegisteredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date receiverDueDate;

    /*
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="RECEIVER_RESPONSIBLE",
            joinColumns = @JoinColumn(name="document_id"),
            inverseJoinColumns = @JoinColumn(name="responsible_id"))
    @Transient
    private Responsible receiverResponsible = new Responsible();


*/


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="receiver_responsible_id")
    private Responsible receiverResponsible;

    @ManyToOne(targetEntity=Executor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverExecutor")
    private Executor receiverExecutor;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverInformation")
    private Information receiverInformation;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverDispatchData")
    private DispatchData receiverDispatchData;
    //endregion

    //region Result Data
    private Long resultStatus;

    private String resultDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date resultCloseDate;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "resultInformation")
    private Information resultInformation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(
            name="RESULT_RESPONSIBLE",
            joinColumns = @JoinColumn(name="document_id"),
            inverseJoinColumns = @JoinColumn(name="responsible_id"))
    private Responsible resultResponsible;
    //endregion

    //region Document GET-SET
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(Long generalStatus) {
        this.generalStatus = generalStatus;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentSubType getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(DocumentSubType documentSubType) {
        this.documentSubType = documentSubType;
    }

    public DocumentTemplate getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }
    //endregion

    //region SenderData GET-SET
    public String getSenderRegisteredNumber() {
        return senderRegisteredNumber;
    }

    public void setSenderRegisteredNumber(String senderRegisteredNumber) {
        this.senderRegisteredNumber = senderRegisteredNumber;
    }

    public Long getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(Long senderStatus) {
        this.senderStatus = senderStatus;
    }

    public Date getSenderRegisteredDate() {
        return senderRegisteredDate;
    }

    public void setSenderRegisteredDate(Date senderRegisteredDate) {
        this.senderRegisteredDate = senderRegisteredDate;
    }

    public Date getSenderDueDate() {
        return senderDueDate;
    }

    public void setSenderDueDate(Date senderDueDate) {
        this.senderDueDate = senderDueDate;
    }

    public Responsible getSenderResponsible() {
        return senderResponsible;
    }

    public void setSenderResponsible(Responsible senderResponsible) {
        this.senderResponsible = senderResponsible;
    }

    public Executor getSenderExecutor() {
        return senderExecutor;
    }

    public void setSenderExecutor(Executor senderExecutor) {
        this.senderExecutor = senderExecutor;
    }

    public Information getSenderInformation() {
        return senderInformation;
    }

    public void setSenderInformation(Information senderInformation) {
        this.senderInformation = senderInformation;
    }

    public DispatchData getSenderDispatchData() {
        return senderDispatchData;
    }

    public void setSenderDispatchData(DispatchData senderDispatchData) {
        this.senderDispatchData = senderDispatchData;
    }
    //endregion

    //region ReceiverData GET-SET
    public String getReceiverRegisteredNumber() {
        return receiverRegisteredNumber;
    }

    public void setReceiverRegisteredNumber(String receiverRegisteredNumber) {
        this.receiverRegisteredNumber = receiverRegisteredNumber;
    }

    public Long getReceiverStatus() {
        return receiverStatus;
    }

    public void setReceiverStatus(Long receiverStatus) {
        this.receiverStatus = receiverStatus;
    }

    public Date getReceiverRegisteredDate() {
        return receiverRegisteredDate;
    }

    public void setReceiverRegisteredDate(Date receiverRegisteredDate) {
        this.receiverRegisteredDate = receiverRegisteredDate;
    }

    public Date getReceiverDueDate() {
        return receiverDueDate;
    }

    public void setReceiverDueDate(Date receiverDueDate) {
        this.receiverDueDate = receiverDueDate;
    }

    public Responsible getReceiverResponsible() {
        return receiverResponsible;
    }

    public void setReceiverResponsible(Responsible receiverResponsible) {
        this.receiverResponsible = receiverResponsible;
    }

    public Executor getReceiverExecutor() {
        return receiverExecutor;
    }

    public void setReceiverExecutor(Executor receiverExecutor) {
        this.receiverExecutor = receiverExecutor;
    }

    public Information getReceiverInformation() {
        return receiverInformation;
    }

    public void setReceiverInformation(Information receiverInformation) {
        this.receiverInformation = receiverInformation;
    }

    public DispatchData getReceiverDispatchData() {
        return receiverDispatchData;
    }

    public void setReceiverDispatchData(DispatchData receiverDispatchData) {
        this.receiverDispatchData = receiverDispatchData;
    }
    //endregion

    //region ResultData GET-SET
    public Long getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Long resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public Date getResultCloseDate() {
        return resultCloseDate;
    }

    public void setResultCloseDate(Date resultCloseDate) {
        this.resultCloseDate = resultCloseDate;
    }

    public Information getResultInformation() {
        return resultInformation;
    }

    public void setResultInformation(Information resultInformation) {
        this.resultInformation = resultInformation;
    }

    public Responsible getresultResponsible() {
        return resultResponsible;
    }

    public void setresultResponsible(Responsible resultResponsible) {
        this.resultResponsible = resultResponsible;
    }
    //endregion
}
