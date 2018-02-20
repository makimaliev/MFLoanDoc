package kg.gov.mf.loan.doc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_dispatch_type")
public class DispatchType extends Catalog {

    public DispatchType() {
    }

    private String internalName;

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }
}
