package kg.gov.mf.loan.doc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cat_document_type")
public class DocumentType extends Catalog {

    public DocumentType() { }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "documentType")
    private Set<DocumentSubType> documentSubTypes = new HashSet<>(0);

    //region GET-SET
    public Set<DocumentSubType> getDocumentSubTypes() {
        return documentSubTypes;
    }

    public void setDocumentSubTypes(Set<DocumentSubType> documentSubTypes) {
        this.documentSubTypes = documentSubTypes;
    }
    //endregion
}
