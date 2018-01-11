package kg.gov.mf.loan.doc.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="cat_task")
public class Task extends Catalog {

    private Date initTime;
    private Date closeTime;
    private Long assignedBy;
    private Long assigmentType;
    private Long assignedTo;
    private Long taskContolledBy;
    private Long taskTrigger;
    private Long taskResult;
    private Long resultApprovedBy;
    private Long parentTask;
    private boolean hasChild;
    private boolean isPeriodic;
    private Long periodInHours;

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Long getAssigmentType() {
        return assigmentType;
    }

    public void setAssigmentType(Long assigmentType) {
        this.assigmentType = assigmentType;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Long getTaskContolledBy() {
        return taskContolledBy;
    }

    public void setTaskContolledBy(Long taskContolledBy) {
        this.taskContolledBy = taskContolledBy;
    }

    public Long getTaskTrigger() {
        return taskTrigger;
    }

    public void setTaskTrigger(Long taskTrigger) {
        this.taskTrigger = taskTrigger;
    }

    public Long getTaskResult() {
        return taskResult;
    }

    public void setTaskResult(Long taskResult) {
        this.taskResult = taskResult;
    }

    public Long getResultApprovedBy() {
        return resultApprovedBy;
    }

    public void setResultApprovedBy(Long resultApprovedBy) {
        this.resultApprovedBy = resultApprovedBy;
    }

    public Long getParentTask() {
        return parentTask;
    }

    public void setParentTask(Long parentTask) {
        this.parentTask = parentTask;
    }

    public boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public boolean getIsPeriodic() {
        return isPeriodic;
    }

    public void setIsPeriodic(boolean isPeriodic) {
        this.isPeriodic = isPeriodic;
    }

    public Long getPeriodInHours() {
        return periodInHours;
    }

    public void setPeriodInHours(Long periodInHours) {
        this.periodInHours = periodInHours;
    }
}
