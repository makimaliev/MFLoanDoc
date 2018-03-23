package kg.gov.mf.loan.doc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name="accounts")
public class Account extends Catalog {

    public Account() {
    }

    private Long atype;

    public Long getAtype() {
        return atype;
    }

    public void setAtype(Long atype) {
        this.atype = atype;
    }
}
