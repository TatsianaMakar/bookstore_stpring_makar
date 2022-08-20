package com.company.controller;

import com.company.repository.entity.Book;
import com.company.service.impl.BookServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("book")
public class BookCommand implements Command {
    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BookCommand(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long idBook = Long.parseLong(req.getParameter("id"));
        Book book = bookServiceImpl.findById(idBook);
        req.setAttribute("book", book);
        return "jsp/book.jsp";

    }


}
