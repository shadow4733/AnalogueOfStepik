package com.user_management_service.dto.Request;

public record UserRequest(
        String username,
        String email,
        String password,
        String passwordConfirm) {
}
