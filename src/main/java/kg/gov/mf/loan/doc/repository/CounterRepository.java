package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Counter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long> {

    @Query("Select c from Counter c where c.department = ?1 and c.documentType = ?2 and c.documentSubType = ?3")
    Counter getCounter(long department, long documentType, long documentSubType);

    @Query("Select c.incoming from Counter c where c.documentType = 0 and c.documentSubType = 0 and c.department = 0")
    Long getIncomingNumber();

    @Query("Select c.outgoing from Counter c where c.documentType = 0 and c.documentSubType = 0 and c.department = 0")
    Long getOutgoingNumber();
}