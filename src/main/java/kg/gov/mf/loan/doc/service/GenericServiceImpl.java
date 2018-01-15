package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.doc.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceImpl<E> implements GenericService<E>
{
    @Autowired
    protected GenericDao<E> dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(E entity) {
    dao.create(entity);
}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void edit(E entity) {
        dao.edit(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(E entity) {
        dao.deleteById(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findById(Long id) {
    return dao.findById(id);
}

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll() {
        return dao.findAll();
    }
}