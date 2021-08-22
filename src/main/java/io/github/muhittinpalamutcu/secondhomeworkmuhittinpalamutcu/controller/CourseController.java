package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Course;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    CourseServiceImpl courseServiceImpl;

    //Dependency injection via constructor
    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    // @desc Get all courses
    // @route Get /api/courses
    // @access Public
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourses() {
        return new ResponseEntity<>(courseServiceImpl.findAll(), HttpStatus.OK);
    }

    // @desc Record new course
    // @route Get /api/courses
    // @access Public
    @PostMapping("/courses")
    public Course saveNewCourse(@RequestBody Course course) {
        return courseServiceImpl.save(course);
    }

    // @desc Get course information by id
    // @route Get /api/courses/{id}
    // @access Public
    @GetMapping("/courses/{id}")
    public Course findCourseById(@PathVariable int id) {
        return courseServiceImpl.findById(id);
    }

    // @desc Update course information by id
    // @route Put /api/courses/{id}
    // @access Public
    @PutMapping("/courses/{id}")
    public Course updateCourseById(@PathVariable int id, @RequestBody Course course) {
        return courseServiceImpl.updateById(id, course);
    }

    // @desc Delete course by id
    // @route Delete /api/courses/{id}
    // @access Public
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
        courseServiceImpl.deleteById(id);
        return new ResponseEntity<>("Course deleted succesfully...", HttpStatus.OK);
    }

}
