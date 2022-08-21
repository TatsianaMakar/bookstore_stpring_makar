package com.company.controller;

import com.company.repository.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("create_user")
public class CreateUserCommand implements Command {
    private final UserServiceImpl userService;

    @Autowired
    public CreateUserCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        User user = new User();
        user.setUserName(req.getParameter("user_name"));
        user.setUserEmail(req.getParameter("user_email"));
        user.setUserPassword(req.getParameter("user_password"));
        User newUser = userService.create(user);
        req.setAttribute("user", newUser);
        req.setAttribute("message", "User has been created");
        return "jsp/user.jsp";
    }
}
