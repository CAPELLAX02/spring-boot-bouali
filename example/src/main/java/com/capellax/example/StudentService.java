package com.capellax.example;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    // Injections
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Constructor
    public StudentService(
            StudentRepository studentRepository,
            StudentMapper studentMapper
    ) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    // Create new student
    public StudentResponseDTO saveStudent(
        StudentDTO studentDTO
    ) {
        var student = studentMapper.toStudent(studentDTO);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDTO(savedStudent);
    }

    // Get all students
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(
            Integer id
    ) {
        return studentRepository
                .findById(id)
                .orElse(null);
    }

    // Get student by name filtering
    public List<Student> findStudentByName(
            String name
    ) {
        return studentRepository.findAllByFirstNameContainingIgnoreCase(name);
    }

    // Delete a student
    public void deleteStudentById(
            Integer id
    ) {
        studentRepository.deleteById(id);
    }

}