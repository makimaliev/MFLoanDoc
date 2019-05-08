package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

    @Query("Select d from Document d where d.documentType.internalName = 'outgoing' and d.senderRegisteredNumber like %?1% order by d.id asc")
    List<Document> searchOutgoingDocuments(String documentNo);
}