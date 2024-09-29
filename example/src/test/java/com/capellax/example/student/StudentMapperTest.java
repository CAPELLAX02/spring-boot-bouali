package com.capellax.example.student;

import org.junit.jupiter.api.*;

class StudentMapperTest {

    @AfterAll
    static void afterAll() {
        System.out.println("after all method.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all method.");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each method.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each method.");
    }

    @Test
    public void testMethod1() {
        System.out.println("1st test method.");
    }

    @Test
    public void testMethod2() {
        System.out.println("2nd test method.");
    }

}