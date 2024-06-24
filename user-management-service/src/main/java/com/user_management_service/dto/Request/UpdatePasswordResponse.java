package com.user_management_service.dto.Request;

public record UpdatePasswordResponse(
    String username,
    String email,
    String role
) {
}
