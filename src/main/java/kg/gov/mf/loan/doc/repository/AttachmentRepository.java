package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}