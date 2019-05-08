package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.DispatchData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchDataRepository extends CrudRepository<DispatchData, Long> {
}