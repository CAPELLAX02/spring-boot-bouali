package com.capellax.example.student;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {

}