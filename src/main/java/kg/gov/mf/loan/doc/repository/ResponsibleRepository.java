package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Responsible;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends CrudRepository<Responsible, Long> {
}