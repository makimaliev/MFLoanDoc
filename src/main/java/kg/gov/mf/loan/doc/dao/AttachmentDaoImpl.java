package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Attachment;
import kg.gov.mf.loan.task.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("attachmentDao")
public class AttachmentDaoImpl extends GenericDaoImpl<Attachment> implements AttachmentDao {
}
