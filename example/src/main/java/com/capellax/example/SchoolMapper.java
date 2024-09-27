package com.capellax.example;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(
            SchoolDTO schoolDto
    ) {
        return new School(schoolDto.name());
    }

    public SchoolDTO toSchoolDTO(
            School school
    ) {
        return new SchoolDTO(school.getName());
    }

}
