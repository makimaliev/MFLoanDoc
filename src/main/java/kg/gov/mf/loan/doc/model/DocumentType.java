package kg.gov.mf.loan.doc.model;

import kg.gov.mf.loan.task.model.Catalog;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name="cat_document_type")
public class DocumentType extends Catalog {

    private String code;
    private String regNoFormat;

    public DocumentType() { }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "documentType")
    private Set<DocumentSubType> documentSubTypes = new HashSet<>(0);

    @Transient
    private Map<State, Boolean> stages;

    //region GET-SET
    public String getRegNoFormat() {
        return regNoFormat;
    }
    public void setRegNoFormat(String regNoFormat) {
        this.regNoFormat = regNoFormat;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Set<DocumentSubType> getDocumentSubTypes() {
        return documentSubTypes;
    }
    public void setDocumentSubTypes(Set<DocumentSubType> documentSubTypes) {
        this.documentSubTypes = documentSubTypes;
    }

    public Map<State, Boolean> getStages() {
        return stages;
    }
    public void setStages(Map<State, Boolean> stages) {
        this.stages = stages;
    }
    //endregion
}
