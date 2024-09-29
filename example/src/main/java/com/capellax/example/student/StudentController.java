package com.capellax.example.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
            @Valid @RequestBody StudentDTO studentDTO
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

    /**
     * Handles exceptions of type MethodArgumentNotValidException.
     *
     * This method is invoked when an argument annotated with
     * {@code @Valid} fails validation in a controller. It captures
     * all validation errors, formats them into a map, and returns
     * a response with the errors and a HTTP 400 (Bad Request) status code.
     *
     * @param exp the exception thrown when a method argument fails validation
     * @return ResponseEntity containing a map of field names and their
     * respective validation error messages, with HTTP status code 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
