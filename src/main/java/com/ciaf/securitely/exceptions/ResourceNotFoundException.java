package com.ciaf.securitely.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource Not Found with id  = " + id);
    }

    public ResourceNotFoundException(String name) {
        super("Resource Not Found with Name  = " + name);
    }
}
