package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.ArchiveDao;
import kg.gov.mf.loan.doc.model.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl extends GenericServiceImpl<Archive> implements ArchiveService
{
    @Autowired
    private ArchiveDao dao;

    @Override
    public Archive findByIdWD(Long id)
    {
        return dao.findByIdWD(id);
    }

    @Override
    public List<Archive> findAllWD()
    {
        return dao.findAllWD();
    }
}
