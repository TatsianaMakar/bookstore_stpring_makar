package com.company.service;

import java.util.List;

public interface AbstractService<K, T> {
    public T findById(K id);

    public List<T> findAll();

    public void delete(K id);

    public T create(T entity);

    public T update(T entity);
}
