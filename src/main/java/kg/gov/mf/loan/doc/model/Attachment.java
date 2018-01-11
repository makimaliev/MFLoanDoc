package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="cat_attachment")
public class Attachment extends Catalog {

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name="information_id")
    private Information information;

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}
