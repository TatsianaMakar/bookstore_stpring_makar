package com.company.repository.impl;

import com.company.AppConfiguration;
import com.company.dao.BookDao;
import com.company.dao.dto.BookDto;
import com.company.dao.entity.Book;
import com.company.repository.BookRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    // private final BookDao bookDao;
    // private final ObjectMapper mapper;

    private final EntityManager entityManager;

    //    public BookRepositoryImpl(BookDao bookDao, ObjectMapper mapper, EntityManager entityManager) {
//        this.bookDao = bookDao;
//        this.mapper = mapper;
//        this.entityManager = entityManager;
//    }
    @Autowired
    public BookRepositoryImpl(EntityManager entityManager) {


        this.entityManager = entityManager;
    }

    @Override
    public Book create(Book entity) {
//        BookDto toSave = mapper.toDto(entity);
//        BookDto savedDto = bookDao.create(toSave);
//        if (savedDto != null) {
//            entity = mapper.toEntity(savedDto);
//        }
//        return entity;
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Book findById(Long id) {

//        BookDto dto = bookDao.findById(id);
//        Book entity = null;
//        if (dto != null) {
//            entity = mapper.toEntity(dto);
//        }
//        return entity;
        return entityManager.find(Book.class, id);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<Book> findAll() {
        // return bookDao.findAll().stream().map(mapper::toEntity).toList();
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("ALL", Book.class).getResultList();
        entityManager.getTransaction().commit();
        return books;
    }

    @Override
    public Book update(Book entity) {
//        BookDto toSave = mapper.toDto(entity);
//        BookDto savedDto = bookDao.update(toSave);
//        if (savedDto != null) {
//            entity = mapper.toEntity(savedDto);
//        }
//        return entity;
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public boolean delete(Long id) {
        //return bookDao.delete(id);
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
