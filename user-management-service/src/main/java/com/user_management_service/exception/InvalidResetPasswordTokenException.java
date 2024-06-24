package com.user_management_service.exception;

public class InvalidResetPasswordTokenException extends RuntimeException {
    public InvalidResetPasswordTokenException(){
        super("Invalid reset password token");
    }
}
