package com.company.controller;

import com.company.repository.entity.Book;
import com.company.repository.entity.User;
import com.company.service.impl.BookServiceImpl;
import com.company.service.impl.UserServiceImpl;
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
        book.setName(req.getParameter("book_name"));
        book.setAuthor(req.getParameter("author"));
        book.setYear(Integer.parseInt(req.getParameter("year")));
       // book.setPrice(BigDecimal.valueOf(Long.parseLong(req.getParameter("price"))));
        book.setIsbn(req.getParameter("isbn"));
       // book.setCover(Book.Cover.valueOf(req.getParameter("cover_name")));
        Book updatedBook = bookService.update(book);
        req.setAttribute("book", updatedBook);
        req.setAttribute("message", "Book has been updated");
        return "jsp/book.jsp";
    }
}
