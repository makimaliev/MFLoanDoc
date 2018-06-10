package kg.gov.mf.loan.doc.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Catalog extends GenericModel {

	private String name;
    private String internalName;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInternalName() {
        return internalName;
    }
    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }
}
