package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao.CourseDAO;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseService implements BaseService<Course> {

    private CourseDAO courseDAO;

    //Dependency injection with CourseDAO interface
    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    @Transactional
    public Course updateById(int id, Course course) {
        return (Course) courseDAO.updateById(id, course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }
}