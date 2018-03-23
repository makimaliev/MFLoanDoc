package kg.gov.mf.loan.doc.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="cat_document_type")
public class DocumentType extends Catalog {

    public DocumentType() { }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "documentSubTypes")
    private Set<DocumentSubType> documentSubTypes;

    public Set<DocumentSubType> getDocumentSubTypes() {
        return documentSubTypes;
    }

    public void setDocumentSubTypes(Set<DocumentSubType> documentSubTypes) {
        this.documentSubTypes = documentSubTypes;
    }

    /*
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof DocumentType) ) return false;

        final DocumentType documentType = (DocumentType) other;

        if(documentType.getId() != getId()) return false;

        return true;
    }
    */
}
