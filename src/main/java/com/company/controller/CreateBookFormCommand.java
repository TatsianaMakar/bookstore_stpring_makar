//package com.company.controller;
//
//
//import com.company.service.impl.BookServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component("create_book_form")
//public class CreateBookFormCommand implements Command {
//    private final BookServiceImpl bookService;
//
//    @Autowired
//    public CreateBookFormCommand(BookServiceImpl bookService) {
//        this.bookService = bookService;
//    }
//
//    @Override
//    public String execute(HttpServletRequest req) {
//        return "jsp/createBookForm.jsp";
//    }
//}
