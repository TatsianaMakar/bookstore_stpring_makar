//package com.company.controller;
//
//import com.company.ContextConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.IOException;
//
//@WebServlet("/controller")
//public final class Controller extends HttpServlet {
//    private AnnotationConfigApplicationContext context;
//
//    @Override
//    public void init() {
//        context = new AnnotationConfigApplicationContext(ContextConfig.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        process(req, res);
//    }
//
//    private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String action = req.getParameter("command");
//        Command command = (Command) context.getBean(action);
//        String page = command.execute(req);
//        req.getRequestDispatcher(page).forward(req, res);
//    }
//
//    public void destroy() {
//        context.close();
//    }
//}
