package kg.gov.mf.loan.doc.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public abstract class GenericDaoImpl<E> implements GenericDao<E>
{
    private SessionFactory sessionFactory;
    private Class<E> entityClass;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    @Transactional
    public E create(E entity) {
        getCurrentSession().persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public E edit(E entity) {
        return (E) getCurrentSession().merge(entity);
    }

    /*
    @Override
    public E save(E entity) {
        if (entity.) {
            getCurrentSession().persist(entity);
            return entity;
        } else {
            return (E)getCurrentSession().merge(entity);
        }
    }
    */

    @Override
    @Transactional
    public void deleteById(E entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @Transactional
    public E findById(Long id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    @Transactional
    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
