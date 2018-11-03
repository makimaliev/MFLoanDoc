package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.service.GenericServiceImpl;
import org.springframework.stereotype.Service;
import kg.gov.mf.loan.doc.model.Executor;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExecutorServiceImpl extends GenericServiceImpl<Executor> implements ExecutorService {
}
