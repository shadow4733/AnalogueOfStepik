package com.user_management_service.dto;

public record AuthenticationRequest(
        String username,
        String password
) {
}
