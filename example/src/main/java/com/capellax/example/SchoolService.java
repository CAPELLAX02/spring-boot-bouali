package com.capellax.example;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    // Injections
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    // Constructor
    public SchoolService(
            SchoolRepository schoolRepository,
            SchoolMapper schoolMapper
    ) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    // Create new school
    public SchoolDTO createSchool(
            @RequestBody SchoolDTO schoolDto
    ) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    // Get all schools
    public List<SchoolDTO> findAll() {
        return schoolRepository
                .findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }

}
