package ru.sultanov.security.securityapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AuthenticationDTO {

    @NotEmpty
    @Size(min = 3, max = 100, message = "Диапазон 3 - 100")
    private String username;

    private String password;
}
