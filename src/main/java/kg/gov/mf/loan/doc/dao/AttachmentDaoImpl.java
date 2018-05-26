package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Attachment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("attachmentDao")
@Transactional
public class AttachmentDaoImpl extends GenericDaoImpl<Attachment> implements AttachmentDao {
}
