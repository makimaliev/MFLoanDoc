package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.model.GenericModel;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Catalog extends GenericModel
{
	private String name;
    private String internalName;

    //region GET-SET
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
    //endregion
}
