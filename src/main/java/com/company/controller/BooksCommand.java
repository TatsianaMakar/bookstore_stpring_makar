package com.company.controller;

import com.company.repository.entity.Book;
import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("books")
public class BooksCommand implements Command {
    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BooksCommand(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Book> books = bookServiceImpl.findAll();
        req.setAttribute("books", books);
        return "jsp/books.jsp";
    }
}
