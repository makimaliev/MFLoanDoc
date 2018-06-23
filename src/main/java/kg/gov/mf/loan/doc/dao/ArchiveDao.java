package kg.gov.mf.loan.doc.dao;

import kg.gov.mf.loan.doc.model.Archive;
import java.util.List;

public interface ArchiveDao extends GenericDao<Archive>
{
    Archive findByIdWD(Long id);
    List<Archive> findAllWD();
}
