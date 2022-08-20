package com.company.repository;

import java.util.List;

public interface AbstractDao<K, T> {
    T create(T entity);

    T findById(K id);

    K countAll();

    List<T> findAll();

    T update(T entity);

    boolean delete(K id);
}
