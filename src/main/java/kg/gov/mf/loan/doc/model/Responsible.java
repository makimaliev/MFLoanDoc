package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.org.model.Department;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;
import kg.gov.mf.loan.admin.org.model.Staff;

import javax.persistence.*;

@Entity
@Table(name="cat_responsible")
public class Responsible extends Catalog {

    @ManyToOne(targetEntity=Organization.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Organization organization;

    @ManyToOne(targetEntity=Department.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Department department;

    @ManyToOne(targetEntity=Staff.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Staff staff;

    @ManyToOne(targetEntity=Person.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Person person;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
