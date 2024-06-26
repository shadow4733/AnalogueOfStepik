package com.user_management_service.dto.Response;


import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        String email,
        String role,
        boolean emailVerified,
        String emailToken,
        LocalDateTime cratedAt
) {
}
