package com.company.controller;

import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("delete_book")
public class DeleteBookCommand implements Command {
    private final BookServiceImpl bookService;

    @Autowired
    public DeleteBookCommand(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        bookService.delete(id);
        return "jsp/delete.jsp";
    }
}
