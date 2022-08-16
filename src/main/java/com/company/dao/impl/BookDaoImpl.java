package com.company.dao.impl;

import com.company.dao.connection.DataSourse;
import com.company.dao.BookDao;
import com.company.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final Logger log = LogManager.getLogger(BookDaoImpl.class);
    private final DataSourse dataSourse;

    public static final String GET_ALL = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.cover_id";

    public static final String GET_BY_ID = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.cover_id " +
            "WHERE books.id=?";

    public static final String GET_BY_ISBN = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.cover_id " +
            "WHERE books.isbn=?";
    public static final String GET_BY_AUTHOR = "SELECT books.id, books.book_name, books.author, " +
            "books.year, books.price, books.isbn, " +
            "covers.cover_name FROM books JOIN covers " +
            "ON books.cover_id=covers.cover_id " +
            "WHERE books.author=?";
    public static final String DELETE_BY_ID = "DELETE FROM books WHERE id=?";
    public static final String ADD_NEW_BOOK = "INSERT INTO books (book_name, author, year, price, isbn, cover_id) VALUES (?,?,?,?,?,(SELECT cover_id FROM covers WHERE cover_name=?))";
    public static final String UPDATE_BY_ID = "UPDATE books SET book_name=?, author=?, year=?, price=?, isbn=?, cover_id=(SELECT cover_id FROM covers WHERE cover_name=?) WHERE id=?";
    public static final String COUNT_BOOKS = "SELECT count(*) AS total FROM books";


    public BookDaoImpl(DataSourse dataSourse) {
        this.dataSourse = dataSourse;
    }

    @Override
    public Book create(Book book) {
        log.debug("Create book={} in table books ", book);
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setBigDecimal(4, book.getPrice());
            statement.setString(5, book.getIsbn());
            statement.setString(6, book.getCover().toString());

            if (statement.executeUpdate() == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    return getById(id);
                }
            }
        } catch (
                SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Book getById(Long id) {
        log.debug("Get book with id={} from table books ", id);
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return creatingBook(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Book getByIsbn(String isbn) {
        log.debug("Get book with isbn={} from table books ", isbn);
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ISBN);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return creatingBook(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        log.debug("Get book with author={} from table books ", author);
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_AUTHOR);
            statement.setString(1, author);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(creatingBook(resultSet));
            }
            return books;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Long countAllBooks() {
        log.debug("Count books");
        try {
            Connection connection = dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_BOOKS);
            if (resultSet.next()) {
                return resultSet.getLong("total");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        throw new RuntimeException("Something wrong");
    }

    @Override
    public List<Book> getAll() {
        log.debug("Get all book from table books ");
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                books.add(creatingBook(resultSet));
            }
            return books;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        log.debug("Update book ={} in table books ", book);
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setLong(7, book.getId());
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setBigDecimal(4, book.getPrice());
            statement.setString(5, book.getIsbn());
            statement.setString(6, book.getCover().toString());
            if (statement.executeUpdate() == 1) {
                return getById(book.getId());
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        log.debug("Delete book with id={} from table books ", id);
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    private Book creatingBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("book_name"));
        book.setAuthor(resultSet.getString("author"));
        book.setYear(resultSet.getInt("year"));
        book.setPrice(resultSet.getBigDecimal("price"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setCover(Book.Cover.valueOf(resultSet.getString("cover_name")));
        return book;
    }
}
