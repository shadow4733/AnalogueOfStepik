package com.user_management_service.dto;

public record AuthenticationResponse(
        String username,
        String password
) {
}
