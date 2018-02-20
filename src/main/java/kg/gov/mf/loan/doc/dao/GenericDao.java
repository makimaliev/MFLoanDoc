package kg.gov.mf.loan.doc.dao;

import java.util.List;

public interface GenericDao<E> {

    E create(E entity);
    void edit(E entity);
    void deleteById(E entity);
    E findById(Long id);
    List<E> findAll();
}