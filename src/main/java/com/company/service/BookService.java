package com.company.service;

import com.company.entity.Book;

import java.math.BigDecimal;

public interface BookService {
    public Book getById(Long id);

    public void delete(Long id);
    public void create(Book entity);

    public Book update(Book entity);
}
