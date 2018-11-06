package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.core.service.GenericServiceImpl;
import kg.gov.mf.loan.doc.model.Executor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExecutorServiceImpl extends GenericServiceImpl<Executor> implements ExecutorService {
}
