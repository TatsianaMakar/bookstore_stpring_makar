package com.company.controller;

import com.company.entity.Book;
import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;


public class BookCommand implements Command {
    private final BookServiceImpl bookService;

    public BookCommand(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String rawId = req.getParameter("id");
        Long idBook = Long.parseLong(rawId);
        Book book = bookService.getById(idBook);
        req.setAttribute("book", book);
        return "jsp/book.jsp";

    }


}
