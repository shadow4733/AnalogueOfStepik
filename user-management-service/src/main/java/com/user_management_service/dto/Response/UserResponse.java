package com.user_management_service.dto.Response;


public record UserResponse(
        String username,
        String email,
        String role,
        boolean emailVerified,
        String emailToken,
        String cratedAt
) {
}
