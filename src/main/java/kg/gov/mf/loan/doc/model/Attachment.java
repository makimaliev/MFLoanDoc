package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.task.listener.MFEntityListener;
import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.*;

@Entity
@Table(name="cat_attachments")
public class Attachment extends Catalog {

    public Attachment() {
    }

    public Attachment(String mimeType) {
        this.mimeType = mimeType;
    }

    private long author;
    @JsonIgnore
    private String mimeType;
    @JsonIgnore
    private String pageIndexNo;

    //region GET-SET
    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
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
    //endregion
}
