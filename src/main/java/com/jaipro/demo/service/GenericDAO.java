package com.jaipro.demo.service;

import java.util.List;

public interface GenericDAO<E> {
    public List<E> findByAll() throws Exception;
    public E findById(Integer id) throws Exception;

     public E save(E entity) throws Exception;

    public E update(Integer id, E entity) throws Exception;

    public void delete(Integer id) throws Exception;

}
