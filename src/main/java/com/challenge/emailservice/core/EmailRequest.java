package com.challenge.emailservice.core;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailRequest(
    @NotBlank @NotNull @Email String to,
    @NotBlank @NotNull String subject,
    @NotBlank @NotNull String body
) {
    
}
