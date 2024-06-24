package com.user_management_service.exception;

public class IncorrectCurrentPasswordException extends RuntimeException {
    public IncorrectCurrentPasswordException(){
        super("Incorrect current password");
    }
}
