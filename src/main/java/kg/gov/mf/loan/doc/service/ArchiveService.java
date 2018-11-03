package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.model.Archive;
import kg.gov.mf.loan.service.GenericService;

import java.util.List;

public interface ArchiveService extends GenericService<Archive>
{
    Archive findByIdWD(Long id);
    List<Archive> findAllWD();
}
