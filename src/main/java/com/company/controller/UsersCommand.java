package com.company.controller;

import com.company.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class UsersCommand implements Command {
    private final UserServiceImpl userService;

    public UsersCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<User> users = userService.findAll();
        req.setAttribute("users", users);
        return "jsp/users.jsp";
    }
}
