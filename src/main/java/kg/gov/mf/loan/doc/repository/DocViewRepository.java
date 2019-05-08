package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.DocView;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocViewRepository extends CrudRepository<DocView, Long>, JpaSpecificationExecutor {
}