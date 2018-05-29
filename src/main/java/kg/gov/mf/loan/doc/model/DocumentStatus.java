package kg.gov.mf.loan.doc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_document_status")
public class DocumentStatus extends Catalog {

    public DocumentStatus() {
    }

    private String actionName;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
