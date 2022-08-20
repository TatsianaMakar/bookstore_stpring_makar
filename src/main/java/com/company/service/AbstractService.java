package com.company.service;

import com.company.repository.entity.Book;

public interface AbstractService<K, T> {
    public T findById(K id);

    public void delete(K id);

    public void create(T entity);

    public T update(T entity);
}
