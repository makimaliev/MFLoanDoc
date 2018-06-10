package kg.gov.mf.loan.doc.service;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.admin.sys.service.UserService;
import kg.gov.mf.loan.doc.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceImpl<E> implements GenericService<E>
{
    @Autowired
    protected GenericDao<E> dao;

    @Autowired
    protected UserService userService;

    @Override
    public E save(E entity) {
        return dao.create(entity);
    }

    @Override
    public void update(E entity) {
        dao.edit(entity);
    }

    @Override
    public void deleteById(E entity) {
        dao.deleteById(entity);
    }

    @Override
    public E findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }
}