package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Attachment;
import kg.gov.mf.loan.service.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttachmentServiceImpl extends GenericServiceImpl<Attachment> implements AttachmentService {
}
