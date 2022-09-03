package com.company.service.impl;

import com.company.dao.entity.Book;
import com.company.repository.impl.BookRepositoryImpl;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryImpl bookRepository;

    @Autowired
    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
        return book;
    }

    @Override
    public void delete(Long id) {
        boolean success = bookRepository.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find book with id=" + id);
        }
    }

    @Override
    public Book create(Book entity) {
        Book book = bookRepository.create(entity);
        validatePrice(book);
        // validateIsbn(entity);
        return book;
    }

    @Override
    public Book update(Book entity) {
        Book book = bookRepository.update(entity);
        validatePrice(book);
        // validateIsbn(entity);
        if (book == null) {
            throw new RuntimeException("Can't find book with");
        }
        return book;
    }

    public void validatePrice(Book book) {
        if (book.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Price is not valid");
        }
    }

//    public void validateIsbn(Book entity) {
//        Book book = bookRepository.findById(entity.getId());
//        if (book != null && Objects.equals(book.getIsbn(), entity.getIsbn())) {
//            throw new RuntimeException("Book with isbn: " + entity.getIsbn() + " already exist");
//        }
//    }

}
