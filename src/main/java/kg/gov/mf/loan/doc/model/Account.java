package kg.gov.mf.loan.doc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Entity;

@Entity
@Immutable
@Table(name="account")
public class Account extends Catalog
{
    public Account() {}
}
