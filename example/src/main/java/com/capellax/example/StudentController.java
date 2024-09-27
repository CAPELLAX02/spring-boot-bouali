package com.capellax.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    // Inject the service
    private final StudentService studentService;

    // Constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create new student
    @PostMapping("/students")
    public StudentResponseDTO saveStudent(
            @RequestBody StudentDTO studentDTO
    ) {
        return this.studentService.saveStudent(studentDTO);
    }

    // Get all students
    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    // Get student by ID
    @GetMapping("/students/{studentId}")
    public Student getStudentById(
            @PathVariable Integer studentId
    ) {
        return this.studentService.getStudentById(studentId);
    }

    // Get student by name filtering
    @GetMapping("/students/search/{studentName}")
    public List<Student> findStudentByName(
            @PathVariable("studentName") String name
    ) {
        return this.studentService.findStudentByName(name);
    }

    // Delete a student
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable Integer studentId
    ) {
        this.studentService.deleteStudentById(studentId);
    }

}
