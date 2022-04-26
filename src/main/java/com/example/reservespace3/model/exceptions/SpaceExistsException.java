package com.example.reservespace3.model.exceptions;

public class SpaceExistsException extends RuntimeException{
    public SpaceExistsException(Long id){
        super("Space with id: %.2f exists!\n Please try again.");
    }
}
