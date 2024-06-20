package com.user_management_service.exception;


import com.user_management_service.dto.UserRequest;

public class PasswordMissmatchException extends RuntimeException {

    public PasswordMissmatchException(){
        super("Password and password confirmations don't match");
    }
}
