package kg.gov.mf.loan.doc.dao;

import java.util.List;

public interface GenericDao<E> {

    void add(E entity);
    List<E> list();
    E getById(Long id);
    void update(E entity);
    void remove(E entity);
}