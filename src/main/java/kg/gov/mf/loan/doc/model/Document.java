package kg.gov.mf.loan.doc.model;

import javax.persistence.*;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    private String title;
    private String description;
    private Long generalStatus;

    @ManyToOne(targetEntity=DocumentType.class, fetch = FetchType.EAGER)
    @JoinColumn
	private DocumentType documentType;

    @ManyToOne(targetEntity=DocumentSubType.class, fetch = FetchType.EAGER)
    @JoinColumn
	private DocumentSubType documentSubType;

    @ManyToOne(targetEntity=DocumentTemplate.class, fetch = FetchType.EAGER)
    @JoinColumn
	private DocumentTemplate documentTemplate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentSubType getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(DocumentSubType documentSubType) {
        this.documentSubType = documentSubType;
    }

    public DocumentTemplate getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public Long getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(Long generalStatus) {
        this.generalStatus = generalStatus;
    }
}
