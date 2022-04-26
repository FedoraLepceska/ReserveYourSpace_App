package com.example.reservespace3.model.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username){
        super(String.format("User with the username: %s is not found", username));
    }
}
