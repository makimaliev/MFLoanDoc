package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="cat_document_subtype")
public class DocumentSubType extends Catalog
{
    public DocumentSubType() { }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="documentType_id")
    private DocumentType documentType;

    //region GET-SET
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
    //endregion
}