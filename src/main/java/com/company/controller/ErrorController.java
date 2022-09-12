package com.company.controller;

import com.company.service.exception.ApplicationException;
import com.company.service.exception.ApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@Controller
@ControllerAdvice
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String error() {
        return "error";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String applicationError(ApplicationException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String applicationError (AccountNotFoundException e, Model model) {
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}

