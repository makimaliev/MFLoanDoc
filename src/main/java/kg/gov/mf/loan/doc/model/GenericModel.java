package kg.gov.mf.loan.doc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class GenericModel implements Serializable {

	private static final long serialVersionUID = -3307436748176180347L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long version = 1L;

    public GenericModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) return true;
        if (!(other instanceof GenericModel)) {
            return false;
        }
        GenericModel genericModel = (GenericModel) other;
        return id.equals(genericModel.id) && Objects.equals(version, genericModel.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }

    /*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;

        GenericModel other = (GenericModel)object;
        return this.getId().equals(other.getId());
    }

	*/
}
