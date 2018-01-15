package kg.gov.mf.loan.doc.service;

import java.util.List;

public interface GenericService<E> {

    void create(E entity);
    void edit(E entity);
    void deleteById(E entity);
    E findById(Long id);
    List<E> findAll();
}