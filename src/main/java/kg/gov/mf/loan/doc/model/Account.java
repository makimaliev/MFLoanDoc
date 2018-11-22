package kg.gov.mf.loan.doc.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.*;

@Entity
@Immutable
@Table(name="account")
public class Account extends Catalog
{
    public Account() {}
}
