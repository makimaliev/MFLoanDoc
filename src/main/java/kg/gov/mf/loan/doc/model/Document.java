package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.Information;
import kg.gov.mf.loan.admin.sys.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    public Document() {}

    //region Document
    private String title = "Title " + new Random().nextInt(100);
    private String description = "Description " + new Random().nextInt(100);

    @ManyToOne
    @JoinColumn(name = "generalStatus")
    private DocumentStatus generalStatus;

    @ManyToOne
    @JoinColumn(name = "documentType")
	private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "documentSubType")
	private DocumentSubType documentSubType;

    @ManyToOne
    @JoinColumn(name = "documentTemplate")
    private DocumentTemplate documentTemplate;

    @Enumerated(EnumType.ORDINAL)
    private State documentState = State.DRAFT;

    @ManyToMany
    @JoinTable(name = "df_document_users",
            joinColumns = { @JoinColumn(name = "Document_id") },
            inverseJoinColumns = { @JoinColumn(name = "users_id") })
    private Set<User> users = new HashSet<>(0);
    //endregion

    //region Sender Data
    private String senderRegisteredNumber;

    @ManyToOne
    @JoinColumn(name = "senderStatus")
    private DocumentStatus senderStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date senderRegisteredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date senderDueDate;

    //*********** Responsible ***********************************************
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderResponsible")
    private Responsible senderResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderExecutor")
    private Executor senderExecutor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderDispatchData")
    private Set<DispatchData> senderDispatchData = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senderInformation")
    private Information senderInformation;

    private String senderFileName;
    //endregion

    //region Receiver Data
    private String receiverRegisteredNumber;

    @ManyToOne
    @JoinColumn(name = "receiverStatus")
    private DocumentStatus receiverStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date receiverRegisteredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date receiverDueDate;

    //*********** Responsible ***********************************************
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverResponsible")
    private Responsible receiverResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverExecutor")
    private Executor receiverExecutor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverDispatchData")
    private Set<DispatchData> receiverDispatchData = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverInformation")
    private Information receiverInformation;

    private String receiverFileName;
    //endregion

    //region Result Data
    private Long resultStatus;
    private String resultDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date resultCloseDate;

    @ManyToOne
    @JoinColumn(name = "resultInformation")
    private Information resultInformation;

    /*
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "resultResponsible")
    private Responsible resultResponsible;
    */
    //endregion

    //region GET-SET

    public State getDocumentState() {
        return documentState;
    }

    public void setDocumentState(State documentState) {
        this.documentState = documentState;
    }

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

    public DocumentStatus getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(DocumentStatus generalStatus) {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public String getSenderRegisteredNumber() {
        return senderRegisteredNumber;
    }

    public void setSenderRegisteredNumber(String senderRegisteredNumber) {
        this.senderRegisteredNumber = senderRegisteredNumber;
    }

    public Responsible getSenderResponsible() {
        return senderResponsible;
    }

    public void setSenderResponsible(Responsible senderResponsible) {
        this.senderResponsible = senderResponsible;
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

    public String getReceiverRegisteredNumber() {
        return receiverRegisteredNumber;
    }

    public void setReceiverRegisteredNumber(String receiverRegisteredNumber) {
        this.receiverRegisteredNumber = receiverRegisteredNumber;
    }

    public DocumentStatus getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(DocumentStatus senderStatus) {
        this.senderStatus = senderStatus;
    }

    public DocumentStatus getReceiverStatus() {
        return receiverStatus;
    }

    public void setReceiverStatus(DocumentStatus receiverStatus) {
        this.receiverStatus = receiverStatus;
    }

    public Responsible getReceiverResponsible() {
        return receiverResponsible;
    }

    public void setReceiverResponsible(Responsible receiverResponsible) {
        this.receiverResponsible = receiverResponsible;
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

    public Set<DispatchData> getSenderDispatchData() {
        return senderDispatchData;
    }

    public void setSenderDispatchData(Set<DispatchData> senderDispatchData) {
        this.senderDispatchData = senderDispatchData;
    }

    public Set<DispatchData> getReceiverDispatchData() {
        return receiverDispatchData;
    }

    public void setReceiverDispatchData(Set<DispatchData> receiverDispatchData) {
        this.receiverDispatchData = receiverDispatchData;
    }

    public String getSenderFileName() {
        return senderFileName;
    }

    public void setSenderFileName(String senderFileName) {
        this.senderFileName = senderFileName;
    }

    public String getReceiverFileName() {
        return receiverFileName;
    }

    public void setReceiverFileName(String receiverFileName) {
        this.receiverFileName = receiverFileName;
    }

    //endregion
}
