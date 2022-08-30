package com.company.repository.impl;

import com.company.dao.BookDao;
import com.company.dao.dto.BookDto;
import com.company.dao.entity.Book;
import com.company.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final BookDao bookDao;
    private final ObjectMapper mapper;

    public BookRepositoryImpl(BookDao bookDao, ObjectMapper mapper) {
        this.bookDao = bookDao;
        this.mapper = mapper;
    }

    @Override
    public Book create(Book entity) {
        BookDto toSave = mapper.toDto(entity);
        BookDto savedDto = bookDao.create(toSave);
        if (savedDto != null) {
            entity = mapper.toEntity(savedDto);
        }
        return entity;
    }

    @Override
    public Book findById(Long id) {
        BookDto dto = bookDao.findById(id);
        Book entity = null;
        if (dto != null) {
            entity = mapper.toEntity(dto);
        }
        return entity;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll().stream().map(mapper::toEntity).toList();
    }

    @Override
    public Book update(Book entity) {
        BookDto toSave = mapper.toDto(entity);
        BookDto savedDto = bookDao.update(toSave);
        if (savedDto != null) {
            entity = mapper.toEntity(savedDto);
        }
        return entity;
    }

    @Override
    public boolean delete(Long id) {
        return bookDao.delete(id);
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
