package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="cat_attachments")
public class Attachment extends Catalog {

    public Attachment() {
    }

    public Attachment(String mimeType) {
        this.mimeType = mimeType;
    }

    private String mimeType;

    private String pageIndexNo;

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
