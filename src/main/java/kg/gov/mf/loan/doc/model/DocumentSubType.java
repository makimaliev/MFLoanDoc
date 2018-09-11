package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.gov.mf.loan.task.model.Task;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cat_document_subtype")
public class DocumentSubType extends Catalog
{
    private String code;

    public DocumentSubType() { }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="documentType_id")
    private DocumentType documentType;

    //region GET-SET
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
    //endregion
}