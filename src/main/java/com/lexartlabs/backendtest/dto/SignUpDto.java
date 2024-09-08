package com.lexartlabs.backendtest.dto;

import com.lexartlabs.backendtest.domain.user.UserRole;

public record SignUpDto(
        String login,
        String password,
        UserRole role) {
}
