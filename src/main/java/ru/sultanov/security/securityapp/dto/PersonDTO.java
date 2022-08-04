package ru.sultanov.security.securityapp.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PersonDTO {

    @NotEmpty
    @Size(min = 3, max = 100, message = "Диапазон 3 - 100")
    private String username;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int yearOfBirth;

    @NotEmpty
    private String password;
}
