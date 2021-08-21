package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    //dependency injection via constructor
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // @desc Get all students
    // @route Get /api/users/students
    // @access Public
    @GetMapping("students")
    public ResponseEntity<List<Student>> findAllStudents() {
        return null;
    }


}
