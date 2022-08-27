package com.company.controller;

import com.company.dao.entity.Book;
import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("create_book")
public class CreateBookCommand implements Command {
    private final BookServiceImpl bookService;

    @Autowired
    public CreateBookCommand(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Book book = new Book();
        book.setBookName(req.getParameter("book_name"));
        book.setAuthor(req.getParameter("author"));
        book.setYear(Integer.parseInt(req.getParameter("year")));
        book.setPrice(new BigDecimal(req.getParameter("price")).setScale(2));
        book.setIsbn(req.getParameter("isbn"));
        book.setCover(Book.Cover.valueOf(req.getParameter("cover_name")));
        bookService.create(book);
        req.setAttribute("book", book);
        req.setAttribute("message", "Book has been created");
        return "jsp/book.jsp";
    }
}
