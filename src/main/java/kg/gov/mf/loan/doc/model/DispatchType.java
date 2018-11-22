package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_dispatch_type")
public class DispatchType extends Catalog {

    public DispatchType() {
    }
}
