package com.user_management_service.exception;


public class PasswordMissmatchException extends RuntimeException {

    public PasswordMissmatchException(){
        super("Password and password confirmations don't match");
    }
}
