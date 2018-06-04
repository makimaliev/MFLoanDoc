package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.org.model.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cat_executor")
public class Executor extends GenericModel {

    public Executor() { }

    private int executorType;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<Organization> organizations = new HashSet<>(0);

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<Department> departments = new HashSet<>(0);

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<Staff> staff = new HashSet<>(0);

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<Person> person = new HashSet<>(0);

    //region GET-SET
    public int getExecutorType() {
        return executorType;
    }

    public void setExecutorType(int executorType) {
        this.executorType = executorType;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }
    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Staff> getStaff() {
        return staff;
    }
    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    public Set<Person> getPerson() {
        return person;
    }
    public void setPerson(Set<Person> person) {
        this.person = person;
    }
    //endregion
}
