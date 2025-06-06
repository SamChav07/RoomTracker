package com.uam.springboot.manager.app.jwt.dto;

import jakarta.validation.constraints.Email;

public record AuthRequestDTO(
        @Email
        String email,
        String password) {
}
