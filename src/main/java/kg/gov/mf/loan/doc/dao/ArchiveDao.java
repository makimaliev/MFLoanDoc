package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.task.dao.GenericDao;
import kg.gov.mf.loan.doc.model.Archive;

import java.util.List;

public interface ArchiveDao extends GenericDao<Archive>
{
    Archive findByIdWD(long id);
    List<Archive> findAllWD();
}
