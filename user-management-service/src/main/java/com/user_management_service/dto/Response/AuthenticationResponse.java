package com.user_management_service.dto.Response;

import java.util.UUID;

public record AuthenticationResponse(
        UUID userId,
        String username,
        String token
) {
}
