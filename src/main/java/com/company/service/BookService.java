package com.company.service;

import com.company.dao.BookDao;
import com.company.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public Book getById(Long id) {
        Book book = bookDao.getById(id);
        if (book == null) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
        return book;
    }

    public void delete(Long id) {
        boolean success = bookDao.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
    }

    public void create(Book entity) {
        Book book = bookDao.create(entity);
        if (entity.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Price can't be less than 0");
        }
    }

    public Book update(Book entity) {
        Book book = bookDao.update(entity);
        if (book == null) {
            throw new RuntimeException("Can't find book with");
        }
        return book;
    }

}
