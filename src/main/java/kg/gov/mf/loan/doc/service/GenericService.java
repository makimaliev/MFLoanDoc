package kg.gov.mf.loan.doc.service;

import java.util.List;

public interface GenericService<E>
{
    E save(E entity);
    void update(E entity);
    void deleteById(E entity);
    E findById(Long id);
    List<E> findAll();
}