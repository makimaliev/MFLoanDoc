package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Executor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorRepository extends CrudRepository<Executor, Long> {
}