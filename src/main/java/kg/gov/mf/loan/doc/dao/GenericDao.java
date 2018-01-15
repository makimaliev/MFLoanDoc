package kg.gov.mf.loan.doc.dao;

import java.util.List;

public interface GenericDao<E> {

    void create(E entity);
    void edit(E entity);
    void deleteById(E entity);
    E findById(Long id);
    List<E> findAll();
}