package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.GenericModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name="df_archive")
public class Archive extends GenericModel {

    public Archive() { }

    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredDate;

    private String registeredNumber;
    private String title;

    @Column(columnDefinition="text")
    private String description = "Description " + new Random().nextInt(100);

    // Location
    private String room;
    private String shelve;
    private String shelveColumn;
    private String shelveRow;
    private String folder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "archiveAttachment")
    private Set<Attachment> attachments = new HashSet<>();

    //region GET-SET
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getShelve() {
        return shelve;
    }

    public void setShelve(String shelve) {
        this.shelve = shelve;
    }

    public String getShelveColumn() {
        return shelveColumn;
    }

    public void setShelveColumn(String shelveColumn) {
        this.shelveColumn = shelveColumn;
    }

    public String getShelveRow() {
        return shelveRow;
    }

    public void setShelveRow(String shelveRow) {
        this.shelveRow = shelveRow;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }
    //endregion
}
