package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseService<Student> {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
    }

    @Override
    public Student updateById(int id) {
        return null;
    }

    @Override
    public void deleteById(int i) {

    }
}
