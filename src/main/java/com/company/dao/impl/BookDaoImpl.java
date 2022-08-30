package com.company.dao.impl;


import com.company.dao.BookDao;
import com.company.dao.dto.BookDto;
import com.company.dao.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger log = LogManager.getLogger(BookDaoImpl.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public static final String GET_ALL = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.id WHERE deleted=FALSE";
    public static final String GET_BY_ID = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.id " +
            "WHERE books.id=? AND deleted=FALSE";
    public static final String GET_BY_ISBN = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.id " +
            "WHERE books.isbn=? AND deleted=FALSE";
    public static final String GET_BY_AUTHOR = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.id " +
            "WHERE books.author=? AND deleted=FALSE";
    public static final String DELETE_BY_ID = "DELETE FROM books WHERE id=?";
    public static final String ADD_NEW_BOOK = "INSERT INTO books (book_name, author, year, price, isbn, cover_id) VALUES (?,?,?,?,?,(SELECT id FROM covers WHERE cover_name=?))";
    public static final String UPDATE_BY_ID = "UPDATE books SET book_name=?, author=?, year=?, price=?, isbn=?, cover_id=(SELECT id FROM covers WHERE cover_name=?) WHERE id=? AND deleted=FALSE";
    public static final String COUNT_BOOKS = "SELECT count(*) AS total FROM books";
    public static final String UPDATE_BY_ID_NAMED = "UPDATE books SET book_name=:book_name, author=:author, year=:year, price=:price, isbn=:isbn, cover_id=(SELECT id FROM covers WHERE cover_name=:cover_name) WHERE id=:id AND deleted=FALSE";


    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public BookDto create(BookDto book) {
        log.debug("Create book={} in table books ", book);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_NEW_BOOK);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.setBigDecimal(4, book.getPrice());
            ps.setString(5, book.getIsbn());
            ps.setString(6, String.valueOf(book.getCover()));
            return ps;
        }, keyHolder);
        Number number = keyHolder.getKey();
        if (number != null) {
            long id = number.longValue();
            return findById(id);
        }
        return null;
    }

    @Override
    public BookDto findById(Long id) {
        log.debug("Get book with id={} from table books ", id);
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    @Override
    public BookDto getByIsbn(String isbn) {
        log.debug("Get book with isbn={} from table books ", isbn);
        return null;
    }

    @Override
    public List<BookDto> getBooksByAuthor(String author) {
        log.debug("Get book with author={} from table books ", author);
        return null;
    }

    @Override
    public Long countAll() {
        log.debug("Count books");
        return 0L;
    }

    @Override
    public List<BookDto> findAll() {
        log.debug("Get all books from table books ");
        return jdbcTemplate.query(GET_ALL, this::mapRow);
    }

    @Override
    public BookDto update(BookDto book) {
        log.debug("Update book ={} in table books ", book);
        Map<String, Object> map = new HashMap<>();
        map.put("id", book.getId());
        map.put("book_name", book.getBookName());
        map.put("author", book.getAuthor());
        map.put("year", book.getYear());
        map.put("price", book.getPrice());
        map.put("isbn", book.getIsbn());
        map.put("cover_name", String.valueOf(book.getCover()));
        namedJdbcTemplate.update(UPDATE_BY_ID_NAMED, map);
        return findById(book.getId());
    }

    @Override
    public boolean delete(Long id) {
        log.debug("Delete book with id={} from table books ", id);
        if (jdbcTemplate.update(DELETE_BY_ID, id) == 1) {
            return true;
        }
        log.debug("Delete book with id={} from table books ", id);
        return false;
    }

    public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookDto bookDto = new BookDto();
        bookDto.setId(rs.getLong("id"));
        bookDto.setBookName(rs.getString("book_name"));
        bookDto.setAuthor(rs.getString("author"));
        bookDto.setYear(rs.getInt("year"));
        bookDto.setPrice(rs.getBigDecimal("price"));
        bookDto.setIsbn(rs.getString("isbn"));
        bookDto.setCover(Book.Cover.valueOf(rs.getString("cover_name")));
        return bookDto;
    }
}
