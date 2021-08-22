package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Course;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student> {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student updateById(int id, Student student) {
        Student student1 = entityManager.find(Student.class, id);

        //Control the @RequestBody JSON for if all the fields are there or not
        //Don't change anything unless there is a new information
        student1.setName(student.getName() == null ? student1.getName() : student.getName());
        student1.setAddress(student.getAddress() == null ? student1.getAddress() : student.getAddress());
        student1.setBirthDate(student.getBirthDate() == null ? student1.getBirthDate() : student.getBirthDate());
        student1.setGender(student.getGender() == null ? student1.getGender() : student.getGender());
        return entityManager.merge(student1);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }


    @Override
    public void enrollInCourse(int id, String courseCode) {
        Student student = entityManager.find(Student.class, id);
        Course course = entityManager.createQuery("from Course c where c.courseCode=:courseCode", Course.class).setParameter("courseCode", courseCode).getSingleResult();
        student.getCourses().add(course);
        entityManager.merge(student);
    }
}
