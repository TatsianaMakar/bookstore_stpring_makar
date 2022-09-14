package com.company.service.exception;

public class ApplicationNotFoundException extends ApplicationException {

    public ApplicationNotFoundException(String message) {
        super(message);
    }

    public ApplicationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
