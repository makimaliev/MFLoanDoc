package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Archive;
import kg.gov.mf.loan.task.service.GenericService;

import java.util.List;

public interface ArchiveService extends GenericService<Archive>
{
    Archive findByIdWD(long id);
    List<Archive> findAllWD();
}
