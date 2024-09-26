package com.capellax.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public School create(
            @RequestBody School school
    ) {
        return schoolRepository.save(school);
    }

    // Get all schools
    @GetMapping("/schools")
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    // Delete school by ID
    @DeleteMapping("/schools/{schoolId}")
    public void delete(
            @PathVariable Integer schoolId
    ) {
        schoolRepository.deleteById(schoolId);
    }


}
