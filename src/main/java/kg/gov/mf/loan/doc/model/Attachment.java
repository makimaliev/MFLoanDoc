package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cat_attachments")
public class Attachment extends Catalog {

    public Attachment() {
    }

    public Attachment(String mimeType) {
        this.mimeType = mimeType;
    }

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    private String mimeType;

    private String pageIndexNo;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getPageIndexNo() {
        return pageIndexNo;
    }

    public void setPageIndexNo(String pageIndexNo) {
        this.pageIndexNo = pageIndexNo;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

}
