package com.company.controller;

import com.company.dao.entity.User;
import com.company.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("user")
public class UserCommand implements Command {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserCommand(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    public String execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userServiceImpl.findById(id);
        req.setAttribute("user", user);
        return "jsp/user.jsp";
    }

}
