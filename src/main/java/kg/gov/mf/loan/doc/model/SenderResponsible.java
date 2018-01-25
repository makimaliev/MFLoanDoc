package kg.gov.mf.loan.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cat_sender_responsible")
public class SenderResponsible extends Responsible {

    @JsonIgnore
    @OneToOne(mappedBy="senderResponsible", cascade = CascadeType.ALL)
    Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
