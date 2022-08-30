package com.company.controller;

import com.company.dao.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("update_user")
public class UpdateUserCommand implements Command {
    private final UserServiceImpl userService;

    @Autowired
    public UpdateUserCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userService.findById(id);
        user.setUserName(req.getParameter("user_name"));
        user.setUserEmail(req.getParameter("user_email"));
        user.setUserPassword(req.getParameter("user_password"));
        User updatedUser = userService.update(user);
        req.setAttribute("user", updatedUser);
        req.setAttribute("message", "User has been updated");
        return "jsp/user.jsp";
    }
}
