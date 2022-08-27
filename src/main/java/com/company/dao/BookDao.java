package com.company.dao;

import com.company.dao.dto.BookDto;
import com.company.dao.entity.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Long, BookDto> {

    BookDto getByIsbn(String isbn);

    List<BookDto> getBooksByAuthor(String author);

}
