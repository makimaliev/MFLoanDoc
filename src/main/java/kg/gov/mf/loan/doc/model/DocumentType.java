package kg.gov.mf.loan.doc.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="cat_document_type")
public class DocumentType extends Catalog {

    public DocumentType() { }

    private String internalName;

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

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
}
