package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cat_receiver_responsible")
public class ReceiverResponsible extends Responsible {

    @JsonIgnore
    @OneToOne(mappedBy="receiverResponsible", cascade = CascadeType.ALL)
    Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
