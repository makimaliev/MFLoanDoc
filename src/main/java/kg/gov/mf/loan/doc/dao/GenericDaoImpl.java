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
    protected Class<E> entityClass;

    public GenericDaoImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public E create(E entity) {
        getCurrentSession().persist(entity);
        getCurrentSession().flush();
        return entity;
    }

    @Override
    public void edit(E entity) {
        getCurrentSession().merge(entity);
    }

    @Override
    public void deleteById(E entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public E findById(Long id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }
}
