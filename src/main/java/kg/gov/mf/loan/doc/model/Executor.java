package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.model.Person;

import javax.persistence.*;

@Entity
@Table(name="cat_executor")
public class Executor extends Catalog {

    @ManyToOne(targetEntity=Organization.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Organization organization;

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
}
