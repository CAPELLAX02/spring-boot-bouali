package com.capellax.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    // Inject the Student Repository
    private final StudentRepository studentRepository;

    // Constructor
    public StudentController(
            StudentRepository studentRepository
    ) {
        this.studentRepository = studentRepository;
    }

    // Create new student
    @PostMapping("/students")
    public Student createStudent(
            @RequestBody Student student
    ) {
        return studentRepository.save(student);
    }

    // Get student by ID
    @GetMapping("/students/{studentId}")
    public Student getStudentById(
            @PathVariable Integer studentId
    ) {
        return studentRepository
                .findById(studentId)
                .orElse(new Student());
    }

    // Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by name
    @GetMapping("/students/search/{studentName}")
    public List<Student> findStudentByName(
            @PathVariable("studentName") String name
    ) {
        return studentRepository
                .findAllByFirstNameContainingIgnoreCase(name);
    }

    // Delete a student
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable Integer studentId
    ) {
        studentRepository.deleteById(studentId);
    }

}
