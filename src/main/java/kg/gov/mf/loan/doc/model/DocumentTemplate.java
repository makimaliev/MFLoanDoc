package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.sys.model.Information;
import kg.gov.mf.loan.task.model.Task;

import javax.persistence.*;

@Entity
@Table(name="cat_document_template")
public class DocumentTemplate extends Catalog {

    /*
    @ManyToOne(targetEntity=Task.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Task task;
    */

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Information information;

    /*
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    */

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}
