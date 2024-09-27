package com.capellax.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    // Inject the school service
    private final SchoolService schoolService;

    // Constructor
    public SchoolController(
            SchoolService schoolService
    ) {
        this.schoolService = schoolService;
    }

    // Create new school
    @PostMapping("/schools")
    public SchoolDTO createSchool(
            @RequestBody SchoolDTO schoolDTO
    ) {
        return this.schoolService.createSchool(schoolDTO);
    }

    // Get all schools
    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return this.schoolService.findAll();
    }

}
