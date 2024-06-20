package com.user_management_service.dto.Request;

public record AuthenticationRequest(
        String username,
        String password
) {
}
