package com.capellax.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    void shouldMapStudentDtoToStudent() {
        StudentDTO studentDTO = new StudentDTO(
                "John",
                "Doe",
                "john@email.com",
                1
        );

        Student student = studentMapper.toStudent(studentDTO);

        assertEquals(studentDTO.firstName(), student.getFirstName());
        assertEquals(studentDTO.lastName(), student.getLastName());
        assertEquals(studentDTO.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDTO.schoolId(), student.getSchool().getId());

    }

    @Test
    void shouldMapStudentToStudentResponseDto() {
        // Given
        Student student = new Student(
                "Jane",
                "Smith",
                "jane@email.com",
                24
        );

        // When
        StudentResponseDTO studentResponseDTO = studentMapper.toStudentResponseDTO(student);

        // Then
        assertEquals(studentResponseDTO.firstName(), student.getFirstName());
        assertEquals(studentResponseDTO.lastName(), student.getLastName());
        assertEquals(studentResponseDTO.email(), student.getEmail());

    }

}