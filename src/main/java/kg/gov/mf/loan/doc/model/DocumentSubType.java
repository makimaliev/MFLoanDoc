package kg.gov.mf.loan.doc.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="cat_document_subtype")
public class DocumentSubType extends Catalog
{
    public DocumentSubType() { }

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
        if ( !(other instanceof DocumentSubType) ) return false;

        final DocumentSubType documentSubType = (DocumentSubType) other;

        if(documentSubType.getId() != getId()) return false;

        return true;
    }
}