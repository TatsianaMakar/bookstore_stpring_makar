package com.company.controller;

import com.company.repository.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("update_user_form")
public class UpdateUserFormCommand implements Command {
    private final UserServiceImpl userService;

    @Autowired
    public UpdateUserFormCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userService.findById(id);
        req.setAttribute("user", user);
        return "jsp/updateUserForm.jsp";
    }
}
