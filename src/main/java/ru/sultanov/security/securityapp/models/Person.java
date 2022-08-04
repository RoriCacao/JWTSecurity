package ru.sultanov.security.securityapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "username")
    @Size(min = 3, max = 100, message = "Диапазон 3 - 100")
    private String username;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", username=" + username + " ,year of birth=" + yearOfBirth + " ,password=" + password + "}";
    }

}
