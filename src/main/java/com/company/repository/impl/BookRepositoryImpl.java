package com.company.repository.impl;

import com.company.dao.entity.Book;
import com.company.dao.entity.User;
import com.company.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book create(Book book) {
        Long id = book.getId();
        if (id == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
        return book;
    }

    @Override
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("from books", Book.class).getResultList();
    }

    @Override
    public boolean delete(Long id) {
        Book book = findById(id);
        if (book == null) {
            return false;
        } else {
            entityManager.remove(book);
            return true;
        }
    }

    @Override
    public Book getByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return null;
    }
}
