package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao.StudentDAO;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements BaseService<Student>, StudentService {

    private StudentDAO studentDAO;

    //Dependency injection with StudentDAO interface
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateById(int id, Student student) {
        return (Student) studentDAO.updateById(id, student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void enrollInCourse(int id, String courseCode) {
        studentDAO.enrollInCourse(id, courseCode);
    }
}
