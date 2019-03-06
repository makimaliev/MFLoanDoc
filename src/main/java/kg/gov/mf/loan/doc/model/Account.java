package kg.gov.mf.loan.doc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.*;

@Entity
@Immutable
@Table(name="account")
public class Account
{
    @Id
    private Long id;
    private String name;
    private String internalName;

    public Account() {}

    //region GET-SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
