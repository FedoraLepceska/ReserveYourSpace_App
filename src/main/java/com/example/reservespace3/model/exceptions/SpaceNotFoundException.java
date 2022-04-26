package com.example.reservespace3.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpaceNotFoundException extends RuntimeException{
    public SpaceNotFoundException(Long id) {
        super(String.format("Product with id: %d was not found", id));
    }
}
