package com.user_management_service.exception;

public class UsernameDoesNotExist extends RuntimeException{
    public UsernameDoesNotExist(String username){
        super("The username does not exist: " + username);
    }
}
