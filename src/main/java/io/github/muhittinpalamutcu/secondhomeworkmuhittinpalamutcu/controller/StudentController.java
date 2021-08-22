package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.EnrollInCourse;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentServiceImpl studentServiceImpl;

    //Dependency injection via constructor
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    // @desc Get all students
    // @route Get /api/students
    // @access Public
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentServiceImpl.findAll(), HttpStatus.OK);
    }

    // @desc Record new student
    // @route Post /api/students
    // @access Public
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentServiceImpl.save(student);
    }

    // @desc Get student information by id
    // @route Get /api/students/{id}
    // @access Public
    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable int id) {
        return studentServiceImpl.findById(id);
    }

    // @desc Update student information by id
    // @route Put /api/students/{id}
    // @access Public
    @PutMapping("/students/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestBody Student student) {
        return studentServiceImpl.updateById(id, student);
    }

    // @desc Delete student by id
    // @route Delete /api/students/{id}
    // @access Public
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        studentServiceImpl.deleteById(id);
        return new ResponseEntity<>("Student deleted succesfully...", HttpStatus.OK);
    }


    /*
    // @desc Student enroll in a course
    // @route Post /api/students/enrollInCourses
    // @access Public
    @PostMapping("/students/enrollInCourses")
    public ResponseEntity<String> studentEnrollInCourse(@RequestBody EnrollInCourse enrollInCourse) {
        studentServiceImpl.enrollInCourse(enrollInCourse.getId(), enrollInCourse.getCourseCode());
        return new ResponseEntity<>("Student successfully enrolled a class: " + enrollInCourse.getCourseCode(), HttpStatus.OK);
    }*/

}
