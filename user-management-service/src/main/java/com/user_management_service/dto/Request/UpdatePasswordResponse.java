package com.user_management_service.dto.Request;

import java.util.UUID;

public record UpdatePasswordResponse(
        UUID userId,
        String username,
        String email,
        String role
) {
}