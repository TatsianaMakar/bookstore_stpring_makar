package com.company.service;

import com.company.repository.entity.Book;

public interface BookService {
    public Book findById(Long id);

    public void delete(Long id);
    public void create(Book entity);

    public Book update(Book entity);
}
