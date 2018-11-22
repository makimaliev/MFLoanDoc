package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_dispatch_template")
public class DispatchTemplate extends Catalog {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
