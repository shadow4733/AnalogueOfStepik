package com.user_management_service.dto.Response;

public record AuthenticationResponse(
        String username,
        String password
) {
}
