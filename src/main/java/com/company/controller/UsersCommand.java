//package com.company.controller;
//
//import com.company.dao.entity.User;
//import com.company.service.impl.UserServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component("users")
//public class UsersCommand implements Command {
//    private final UserServiceImpl userService;
//
//    @Autowired
//    public UsersCommand(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public String execute(HttpServletRequest req) {
//        List<User> users = userService.findAll();
//        req.setAttribute("users", users);
//        return "jsp/users.jsp";
//    }
//}
