package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.Information;
import kg.gov.mf.loan.admin.sys.model.User;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    public Document() {}

    //region Document
    private Long owner;
    private String title = "Title " + new Random().nextInt(100);

    @Column(columnDefinition="text")
    private String description = "Description " + new Random().nextInt(100);
    private Boolean archived = false;

    @Transient
    private String comment;

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
    private State documentState = State.NEW;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<User> users = new HashSet<>(0);
    //endregion
    //region Sender Data
    private String senderRegisteredNumber;

    @ManyToOne
    @JoinColumn(name = "senderStatus")
    private DocumentStatus senderStatus;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date senderRegisteredDate;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date senderDueDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "senderResponsible")
    private Responsible senderResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "senderExecutor")
    private Executor senderExecutor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderDispatchData")
    @OrderBy("id asc")
    private Set<DispatchData> senderDispatchData = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senderInformation")
    private Information senderInformation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "senderAttachment")
    private Set<Attachment> senderAttachment = new HashSet<>();
    //endregion
    //region Receiver Data
    private String receiverRegisteredNumber;

    @ManyToOne
    @JoinColumn(name = "receiverStatus")
    private DocumentStatus receiverStatus;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiverRegisteredDate;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiverDueDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "receiverResponsible")
    private Responsible receiverResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "receiverExecutor")
    private Executor receiverExecutor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverDispatchData")
    @OrderBy("id asc")
    private Set<DispatchData> receiverDispatchData = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverInformation")
    private Information receiverInformation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverAttachment")
    private Set<Attachment> receiverAttachment = new HashSet<>();
    //endregion

    //region GET-SET
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
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

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
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

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public State getDocumentState() {
        return documentState;
    }

    public void setDocumentState(State documentState) {
        this.documentState = documentState;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getSenderRegisteredNumber() {
        return senderRegisteredNumber;
    }

    public void setSenderRegisteredNumber(String senderRegisteredNumber) {
        this.senderRegisteredNumber = senderRegisteredNumber;
    }

    public DocumentStatus getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(DocumentStatus senderStatus) {
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

    public Set<DispatchData> getSenderDispatchData() {
        return senderDispatchData;
    }

    public void setSenderDispatchData(Set<DispatchData> senderDispatchData) {
        this.senderDispatchData = senderDispatchData;
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

    public DocumentStatus getReceiverStatus() {
        return receiverStatus;
    }

    public void setReceiverStatus(DocumentStatus receiverStatus) {
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

    public Set<DispatchData> getReceiverDispatchData() {
        return receiverDispatchData;
    }

    public void setReceiverDispatchData(Set<DispatchData> receiverDispatchData) {
        this.receiverDispatchData = receiverDispatchData;
    }

    public Information getReceiverInformation() {
        return receiverInformation;
    }

    public void setReceiverInformation(Information receiverInformation) {
        this.receiverInformation = receiverInformation;
    }

    public Set<Attachment> getSenderAttachment() {
        return senderAttachment;
    }

    public void setSenderAttachment(Set<Attachment> senderAttachment) {
        this.senderAttachment = senderAttachment;
    }

    public Set<Attachment> getReceiverAttachment() {
        return receiverAttachment;
    }

    public void setReceiverAttachment(Set<Attachment> receiverAttachment) {
        this.receiverAttachment = receiverAttachment;
    }
    //endregion
}
