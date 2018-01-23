package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.gov.mf.loan.admin.org.model.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="cat_responsible")
public class Responsible extends GenericModel {

    public Responsible() {
    }

    private int responsibleType;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Organization> organizations = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Department> departments = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Staff> staff = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Person> person = new HashSet<>();

    public int getResponsibleType() {
        return responsibleType;
    }

    public void setResponsibleType(int responsibleType) {
        this.responsibleType = responsibleType;
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
}
