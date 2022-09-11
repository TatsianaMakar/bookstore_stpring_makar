package com.company.service.exception;

public class ApplicationValidationException extends ApplicationException {

    public ApplicationValidationException(String message) {
        super(message);
    }

    public ApplicationValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
