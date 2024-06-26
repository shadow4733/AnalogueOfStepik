package com.user_management_service.dto.Response;

import java.util.UUID;

public record UpdatePasswordRequest(
        UUID userId,
        String resetPasswordToken,
        String currentPassword,
        String newPassword
) {
}
