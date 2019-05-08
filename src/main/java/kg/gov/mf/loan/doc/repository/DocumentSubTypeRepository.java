package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.DocumentSubType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSubTypeRepository extends CrudRepository<DocumentSubType, Long> {

    DocumentSubType getByInternalName(String internalName);
}