package kg.gov.mf.loan.doc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<E> implements GenericDao<E>
{
    protected Class<? extends E> entityClass;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class) pt.getActualTypeArguments()[0];
    }

    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(E entity) {
        getCurrentSession().persist(entity);
    }

    public void edit(E entity) {
        getCurrentSession().merge(entity);
    }

    public void deleteById(E entity) {
        getCurrentSession().delete(entity);
    }

    public E findById(Long id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }

}
