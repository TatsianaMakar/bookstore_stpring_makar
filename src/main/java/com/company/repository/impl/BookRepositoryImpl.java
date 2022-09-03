package com.company.repository.impl;

import com.company.dao.entity.Book;
import com.company.repository.BookRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager;

    @Autowired
    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Book create(Book entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
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
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("from books", Book.class).getResultList();
        entityManager.getTransaction().commit();
        return books;
    }

    @Override
    public Book update(Book entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
        return true;
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
