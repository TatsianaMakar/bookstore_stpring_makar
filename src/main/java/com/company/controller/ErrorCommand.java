package com.company.controller;


import jakarta.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return "jsp/error.jsp";
    }
}
