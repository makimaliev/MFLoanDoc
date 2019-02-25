package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name="documentview")
public class DocView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String indexNo;
    private Integer pageCount;
    private Long docIndex;
    private String owner;
    private String title;
    private String description;
    private long documentType;
    private String documentSubType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private Date documentDueDate;
    private String documentState;

    private String senderRegisteredNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private Date senderRegisteredDate;
    private String senderResponsible;
    private String senderExecutor;

    private String receiverRegisteredNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private Date receiverRegisteredDate;
    private String receiverResponsible;
    private String receiverExecutor;
    private String users;

    //private long[] attachments;
    //private long[] documentLinks;

    //region GET-SET

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getDocIndex() {
        return docIndex;
    }

    public void setDocIndex(Long docIndex) {
        this.docIndex = docIndex;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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

    public long getDocumentType() {
        return documentType;
    }

    public void setDocumentType(long documentType) {
        this.documentType = documentType;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
    }

    public Date getDocumentDueDate() {
        return documentDueDate;
    }

    public void setDocumentDueDate(Date documentDueDate) {
        this.documentDueDate = documentDueDate;
    }

    public String getDocumentState() {
        return documentState;
    }

    public void setDocumentState(String documentState) {
        this.documentState = documentState;
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

    public String getSenderResponsible() {
        return senderResponsible;
    }

    public void setSenderResponsible(String senderResponsible) {
        this.senderResponsible = senderResponsible;
    }

    public String getSenderExecutor() {
        return senderExecutor;
    }

    public void setSenderExecutor(String senderExecutor) {
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

    public String getReceiverResponsible() {
        return receiverResponsible;
    }

    public void setReceiverResponsible(String receiverResponsible) {
        this.receiverResponsible = receiverResponsible;
    }

    public String getReceiverExecutor() {
        return receiverExecutor;
    }

    public void setReceiverExecutor(String receiverExecutor) {
        this.receiverExecutor = receiverExecutor;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    /*
    public long[] getAttachments() {
        return attachments;
    }

    public void setAttachments(long[] attachments) {
        this.attachments = attachments;
    }

    public long[] getDocumentLinks() {
        return documentLinks;
    }

    public void setDocumentLinks(long[] documentLinks) {
        this.documentLinks = documentLinks;
    }
    */
    //endregion
}
