package com.mentorondemand.routing.exception;

import org.springframework.http.HttpStatus;

public class ProgramException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public ProgramException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
