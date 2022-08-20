package com.company.service.impl;

import com.company.dao.BookDao;
import com.company.dao.impl.BookDaoImpl;
import com.company.entity.Book;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDaoImpl bookDaoImpl;

    @Autowired
    public BookServiceImpl(BookDaoImpl bookDaoImpl) {
        this.bookDaoImpl = bookDaoImpl;
    }

    public List<Book> findAll() {
        return bookDaoImpl.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book = bookDaoImpl.findById(id);
        if (book == null) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
        return book;
    }

    @Override
    public void delete(Long id) {
        boolean success = bookDaoImpl.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
    }

    @Override
    public void create(Book entity) {
        Book book = bookDaoImpl.create(entity);
        validate(book);
    }

    @Override
    public Book update(Book entity) {
        Book book = bookDaoImpl.update(entity);
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
