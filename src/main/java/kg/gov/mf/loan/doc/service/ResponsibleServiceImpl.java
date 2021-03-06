package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Responsible;
import kg.gov.mf.loan.task.service.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResponsibleServiceImpl extends GenericServiceImpl<Responsible> implements ResponsibleService {
}
