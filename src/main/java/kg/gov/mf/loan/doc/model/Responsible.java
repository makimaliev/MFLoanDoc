package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="cat_responsible")
public class Responsible extends Catalog {

    @ManyToOne(targetEntity=Organization.class, fetch = FetchType.EAGER)
    @JoinColumn(name="organization_id")
    private Organization organization;

    @ManyToOne(targetEntity=Person.class, fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
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
