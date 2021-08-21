package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    // @desc Record new student
    // @route Post /api/users/students
    // @access Public
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // @desc Get student information by id
    // @route Get /api/users/students/{id}
    // @access Public
    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    // @desc Update student information by id
    // @route Put /api/users/students/{id}
    // @access Public
    @PutMapping("/students/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateById(id, student);
    }

    // @desc Delete student by id
    // @route Delete /api/users/students/{id}
    // @access Public
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        studentService.deleteById(id);
        return new ResponseEntity<>("Student deleted succesfully...", HttpStatus.OK);
    }

}
