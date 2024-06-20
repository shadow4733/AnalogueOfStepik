package com.user_management_service.exception;

public class PasswordIsIncorrect extends RuntimeException{
    public PasswordIsIncorrect(){
        super("The password is incorrect");
    }
}
