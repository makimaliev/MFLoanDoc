package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {

    DocumentType getByInternalName(String internalName);
}