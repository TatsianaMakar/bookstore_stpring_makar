package com.company.controller;

import com.company.dao.entity.Book;
import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("update_book")
public class UpdateBookCommand implements Command {
    private final BookServiceImpl bookService;

    @Autowired
    public UpdateBookCommand(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        Book book = bookService.findById(id);
        book.setBookName(req.getParameter("book_name"));
        book.setAuthor(req.getParameter("author"));
        book.setYear(Integer.parseInt(req.getParameter("year")));
        book.setPrice(new BigDecimal(req.getParameter("price")));
        book.setIsbn(req.getParameter("isbn"));
      //  book.setCover(Book.Cover.valueOf(req.getParameter("cover_name")));
        Book updatedBook = bookService.update(book);
        req.setAttribute("book", updatedBook);
        req.setAttribute("message", "Book has been updated");
        return "jsp/book.jsp";
    }
}
