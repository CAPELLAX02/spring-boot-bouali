package com.capellax.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty(message = "First name cannot be empty!")
        String firstName,

        @NotEmpty(message = "Last name cannot be empty!")
        String lastName,

        @Email(message = "Email must be a valid email!")
        String email,

        Integer schoolId
) {

}