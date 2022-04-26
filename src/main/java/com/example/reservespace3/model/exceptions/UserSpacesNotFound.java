package com.example.reservespace3.model.exceptions;

public class UserSpacesNotFound extends RuntimeException{
    public UserSpacesNotFound(Long id){
        super(String.format("User repo: %s already exists", id));
    }
}
