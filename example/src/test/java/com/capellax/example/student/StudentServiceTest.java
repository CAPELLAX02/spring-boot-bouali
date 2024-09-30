package com.capellax.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    // Service instance to be tested
    @InjectMocks
    private StudentService studentService;

    // Declare the dependencies
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_successfully_save_a_student() {
        // Given
        StudentDTO studentDTO = new StudentDTO(
                "John",
                "Doe",
                "john@email.com",
                1
        );

        Student student = new Student(
                "John",
                "Doe",
                "john@email.com",
                1
        );

        Student savedStudent = new Student(
                "John",
                "Doe",
                "john@email.com",
                1
        );

        savedStudent.setId(1);

        // Mock the calls
        Mockito.when(studentMapper.toStudent(studentDTO))
                .thenReturn(student);

        Mockito.when(studentRepository.save(student))
                .thenReturn(savedStudent);

        Mockito.when(studentMapper.toStudentResponseDTO(savedStudent))
                .thenReturn(new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john@email.com",
                        1
                ));

        // When
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(studentDTO);

        // Then
        assertEquals(studentDTO.firstName(), studentResponseDTO.firstName());
        assertEquals(studentDTO.lastName(), studentResponseDTO.lastName());
        assertEquals(studentDTO.email(), studentResponseDTO.email());

    }
}