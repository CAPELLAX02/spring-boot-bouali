package com.capellax.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<StudentResponseDTO> findAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    // Get student by ID
    public StudentResponseDTO getStudentById(
            Integer id
    ) {
        return studentRepository
                .findById(id)
                .map(studentMapper::toStudentResponseDTO)
                .orElse(null);
    }

    // Get student by name filtering
    public List<StudentResponseDTO> findStudentByName(
            String name
    ) {
        return studentRepository
                .findAllByFirstNameContainingIgnoreCase(name)
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    // Delete a student
    public void deleteStudentById(
            Integer id
    ) {
        studentRepository.deleteById(id);
    }

}