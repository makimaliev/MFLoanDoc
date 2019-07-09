package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;
import kg.gov.mf.loan.task.model.GenericModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="df_counter")
public class Counter extends Catalog
{
    private long department;
    private long documentType;
    private long documentSubType;
    private long incoming;
    private long outgoing;

    //region GET-SET
    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }

    public long getDocumentType() {
        return documentType;
    }

    public void setDocumentType(long documentType) {
        this.documentType = documentType;
    }

    public long getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(long documentSubType) {
        this.documentSubType = documentSubType;
    }

    public long getIncoming() {
        return incoming;
    }

    public void setIncoming(long incoming) {
        this.incoming = incoming;
    }

    public long getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(long outgoing) {
        this.outgoing = outgoing;
    }
    //endregion
}
