package kg.gov.mf.loan.doc.service;

import java.util.List;

public interface GenericService<E> {

    void add(E entity);
    List<E> list();
    E getById(Long id);
    void update(E entity);
    void remove(E entity);
}