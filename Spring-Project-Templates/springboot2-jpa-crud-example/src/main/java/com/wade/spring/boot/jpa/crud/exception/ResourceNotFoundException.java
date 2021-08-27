package com.wade.spring.boot.jpa.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 7913916596973511368L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
