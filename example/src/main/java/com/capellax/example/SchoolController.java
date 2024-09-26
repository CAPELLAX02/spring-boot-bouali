package com.capellax.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    // Inject the School Repository
    private final SchoolRepository schoolRepository;

    // Constructor
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    // Create new school
    @PostMapping("/schools")
    public SchoolDTO create(
            @RequestBody SchoolDTO schoolDto
    ) {
        var school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    private School toSchool(SchoolDTO schoolDto) {
        return new School(schoolDto.name());
    }

    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }

    // Get all schools
    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolRepository
                .findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());
    }

}
