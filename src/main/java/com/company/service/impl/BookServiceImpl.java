package com.company.service.impl;

import com.company.dao.entity.Book;
import com.company.repository.BookRepository;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public Book create(Book book) {
        Book newBook = bookRepository.create(book);
        validateIsbn(book);
        return newBook;
      }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
        if (!bookRepository.delete(id)) {
            throw new RuntimeException("No user with id: " + id);
        }
    }

        public void validateIsbn(Book entity) {
        List<Book> books = findAll();
        for (int j = 0; j < books.size() - 1; j++) {
            if (books.get(j) != null && Objects.equals(books.get(j).getIsbn(), entity.getIsbn())) {
                throw new RuntimeException("Book with isbn: " + entity.getIsbn() + " already exist");
            }
        }
    }
}


