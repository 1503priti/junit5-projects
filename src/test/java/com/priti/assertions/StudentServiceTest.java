package com.priti.assertions;

import com.priti.Student;
import com.priti.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){
        StudentService studentService = new StudentService();
        List<Student> listOfStudents = studentService.getStudents();
        boolean actualResult = listOfStudents.isEmpty();
        assertTrue(actualResult);
    }

}