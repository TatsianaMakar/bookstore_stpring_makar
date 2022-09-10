//package com.company.controller;
//
//import com.company.service.impl.UserServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component("create_user_form")
//public class CreateUserFormCommand implements Command {
//    private final UserServiceImpl userService;
//
//    @Autowired
//    public CreateUserFormCommand(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public String execute(HttpServletRequest req) {
////        User user=new User();
////        req.setAttribute("user", user);
//        return "jsp/createUserForm.jsp";
//    }
//}
