package kg.gov.mf.loan.doc.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
public abstract class GenericDaoImpl<E> implements GenericDao<E>
{
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<E> entityClass;

    public GenericDaoImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public E create(final E entity) {
        getCurrentSession().persist(entity);
        return entity;
    }

    @Override
    public void edit(final E entity) {
        getCurrentSession().merge(entity);
    }

    @Override
    public void deleteById(final E entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public E findById(final Long id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }
}
