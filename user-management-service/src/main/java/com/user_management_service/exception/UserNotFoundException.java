package com.user_management_service.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID uuid){
        super("User not found.");
    }
}
