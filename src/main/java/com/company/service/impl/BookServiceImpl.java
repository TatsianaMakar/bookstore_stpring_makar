package com.company.service.impl;

import com.company.dao.BookDao;
import com.company.entity.Book;
import com.company.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book getById(Long id) {
        Book book = bookDao.findById(id);
        if (book == null) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
        return book;
    }

    @Override
    public void delete(Long id) {
        boolean success = bookDao.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
    }

    @Override
    public void create(Book entity) {
        Book book = bookDao.create(entity);
        validate(book);
    }

    @Override
    public Book update(Book entity) {
        Book book = bookDao.update(entity);
        validate(book);
        if (book == null) {
            throw new RuntimeException("Can't find book with");
        }
        return book;
    }

    public void validate(Book book) {
        if (book.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Price is not valid");
        }
    }

}
