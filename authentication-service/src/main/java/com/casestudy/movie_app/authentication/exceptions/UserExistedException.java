package com.casestudy.movie_app.authentication.exceptions;

public class UserExistedException extends RuntimeException{
    public UserExistedException(String message){
        super(message);
    }
}
