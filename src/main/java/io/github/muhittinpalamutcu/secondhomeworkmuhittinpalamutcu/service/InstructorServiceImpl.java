package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao.InstructorDAO;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorServiceImpl implements BaseService<Instructor> {

    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    @Transactional
    public Instructor updateById(int id, Instructor instructor) {
        return (Instructor) instructorDAO.updateById(id, instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }
}
