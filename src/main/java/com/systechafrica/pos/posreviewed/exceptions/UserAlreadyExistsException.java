package com.systechafrica.pos.posreviewed.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String s){
        super(s);
    }
}
