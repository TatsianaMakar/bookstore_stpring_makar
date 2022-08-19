package com.company.controller;

import com.company.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class UserCommand implements Command {
    private final UserServiceImpl userService;

    public UserCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String rawId = req.getParameter("id");
        Long idUser = Long.parseLong(rawId);
        User user = userService.getById(idUser);
        req.setAttribute("user", user);
        return "jsp/user.jsp";
    }

}
