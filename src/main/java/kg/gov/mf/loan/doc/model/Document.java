package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.task.model.GenericModel;
import kg.gov.mf.loan.task.listener.MFEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="df_document")
@EntityListeners(MFEntityListener.class)
public class Document extends GenericModel {

    public Document() {}

    //region Document
    @JsonIgnore
    private long owner;
    private String title;

    @Column(columnDefinition="text")
    private String description = " ";

    @JsonIgnore
    private String indexNo;
    @JsonIgnore
    private int pageCount = 1;
    @JsonIgnore
    private long docIndex;
    @JsonIgnore
    private boolean received = true;

    @Transient
    @JsonIgnore
    private String comment;

    @Transient
    @JsonIgnore
    private List<Staff> reconciler;

    @Transient
    @JsonIgnore
    private List<Staff> executor;

    @ManyToOne
    @JoinColumn(name = "documentType", foreignKey = @ForeignKey(name = "DOCUMENT_TYPE_ID_FK"))
	private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "documentSubType", foreignKey = @ForeignKey(name = "DOCUMENT_SUBTYPE_ID_FK"))
	private DocumentSubType documentSubType;

    @Temporal(TemporalType.DATE)
    private Date documentDueDate;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private State documentState = State.NEW;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dispatchData")
    @OrderBy("id asc")
    private Set<DispatchData> dispatchData = new LinkedHashSet<>(0);

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn
    private Set<User> users = new LinkedHashSet<>(0);

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "documentAttachments")
    private Set<Attachment> attachments = new LinkedHashSet<>(0);

    private Long[] documentLinks;

    //endregion
    //region Sender Data
    private String senderRegisteredNumber;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date senderRegisteredDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "senderResponsible")
    private Responsible senderResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "senderExecutor")
    private Executor senderExecutor;
    //endregion
    //region Receiver Data
    private String receiverRegisteredNumber;

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiverRegisteredDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "receiverResponsible")
    private Responsible receiverResponsible;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "receiverExecutor")
    private Executor receiverExecutor;
    //endregion
    //region GET-SET.

    public Long[] getDocumentLinks() {
        return documentLinks;
    }

    public void setDocumentLinks(Long[] documentLinks) {
        this.documentLinks = documentLinks;
    }

    public long getDocIndex() {
        return docIndex;
    }

    public void setDocIndex(long docIndex) {
        this.docIndex = docIndex;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Staff> getReconciler() {
        return reconciler;
    }

    public void setReconciler(List<Staff> reconciler) {
        this.reconciler = reconciler;
    }

    public List<Staff> getExecutor() {
        return executor;
    }

    public void setExecutor(List<Staff> executor) {
        this.executor = executor;
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

    public Date getDocumentDueDate() {
        return documentDueDate;
    }

    public void setDocumentDueDate(Date documentDueDate) {
        this.documentDueDate = documentDueDate;
    }

    public State getDocumentState() {
        return documentState;
    }

    public void setDocumentState(State documentState) {
        this.documentState = documentState;
    }

    public Set<DispatchData> getDispatchData() {
        return dispatchData;
    }

    public void setDispatchData(Set<DispatchData> dispatchData) {
        this.dispatchData = dispatchData;
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

    public Date getSenderRegisteredDate() {
        return senderRegisteredDate;
    }

    public void setSenderRegisteredDate(Date senderRegisteredDate) {
        this.senderRegisteredDate = senderRegisteredDate;
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

    public String getReceiverRegisteredNumber() {
        return receiverRegisteredNumber;
    }

    public void setReceiverRegisteredNumber(String receiverRegisteredNumber) {
        this.receiverRegisteredNumber = receiverRegisteredNumber;
    }

    public Date getReceiverRegisteredDate() {
        return receiverRegisteredDate;
    }

    public void setReceiverRegisteredDate(Date receiverRegisteredDate) {
        this.receiverRegisteredDate = receiverRegisteredDate;
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
    //endregion
}
