package com.company.repository;

import com.company.dao.entity.Book;

import java.util.List;

public interface BookRepository extends AbstractRepository<Long, Book> {
    Book getByIsbn(String isbn);

    List<Book> getBooksByAuthor(String author);
}
