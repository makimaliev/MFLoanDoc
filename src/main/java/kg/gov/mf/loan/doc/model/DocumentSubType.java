package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="cat_document_subtype")
public class DocumentSubType extends Catalog {

    @ManyToOne(targetEntity=DocumentType.class, fetch = FetchType.EAGER)
    @JoinColumn
    DocumentType documentType;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}