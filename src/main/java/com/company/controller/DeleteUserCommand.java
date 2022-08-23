package com.company.controller;

import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("delete_user")
public class DeleteUserCommand implements Command {
    private final UserServiceImpl userService;

    @Autowired
    public DeleteUserCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.delete(id);
        return "jsp/delete.jsp";
    }
}
