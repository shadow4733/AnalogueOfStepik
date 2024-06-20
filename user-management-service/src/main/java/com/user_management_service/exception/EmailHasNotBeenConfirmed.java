package com.user_management_service.exception;

public class EmailHasNotBeenConfirmed extends RuntimeException{
    public EmailHasNotBeenConfirmed(){
        super("The mail has not been confirmed");
    }
}
