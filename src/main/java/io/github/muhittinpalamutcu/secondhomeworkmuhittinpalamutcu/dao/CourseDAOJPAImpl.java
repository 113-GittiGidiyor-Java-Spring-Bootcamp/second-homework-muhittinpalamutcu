package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("from Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public Course updateById(int id, Course course) {
        Course course1 = entityManager.find(Course.class, id);

        //Control the @RequestBody JSON for if all the fields are there or not
        //Don't change anything unless there is a new information
        course1.setName(course.getName() == null ? course1.getName() : course.getName());
        course1.setCourseCode(course.getCourseCode() == null ? course1.getCourseCode() : course.getCourseCode());
        course1.setCreditScore(course.getCreditScore() == 0 ? course1.getCreditScore() : course.getCreditScore());
        return entityManager.merge(course1);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }
}
