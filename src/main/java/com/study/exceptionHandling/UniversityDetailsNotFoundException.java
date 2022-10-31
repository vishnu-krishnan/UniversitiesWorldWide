package com.study.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UniversityDetailsNotFoundException extends RuntimeException {
    public UniversityDetailsNotFoundException(String message) {
        super(message);
    }
}
