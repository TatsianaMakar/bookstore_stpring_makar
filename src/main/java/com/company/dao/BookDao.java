package com.company.dao;

import com.company.entity.Book;

import java.util.List;

public interface BookDao {
    //create
    Book create(Book book);

    //read
    Book getById(Long id);

    Book getByIsbn(String isbn);

    List<Book> getBooksByAuthor(String author);

    Long countAllBooks();

    List<Book> getAll();

    //update
    Book update(Book book);

    //delete
    boolean delete(Long id);

    }
