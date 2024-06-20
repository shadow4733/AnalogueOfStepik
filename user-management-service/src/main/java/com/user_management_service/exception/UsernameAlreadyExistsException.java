package com.user_management_service.exception;

import com.user_management_service.dto.UserRequest;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username){
        super("Username with username " + username + " already exists");
    }
}
