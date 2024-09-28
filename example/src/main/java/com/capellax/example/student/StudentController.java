package com.capellax.example.student;

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
    public List<StudentResponseDTO> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    // Get student by ID
    @GetMapping("/students/{studentId}")
    public StudentResponseDTO getStudentById(
            @PathVariable Integer studentId
    ) {
        return this.studentService.getStudentById(studentId);
    }

    // Get student by name filtering
    @GetMapping("/students/search/{studentName}")
    public List<StudentResponseDTO> findStudentByName(
            @PathVariable("studentName") String name
            /**
             * We could have either do:
             *     1 - @PathVariable("studentName") String name
             *     2 - @PathVariable String studentName
             */
    ) {
        return this.studentService.findStudentByName(name);
        /**
         * We could have either do:
         *     1 - return this.studentService.findStudentByName(name);
         *     2 - return this.studentService.findStudentByName(studentName);
         */
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
