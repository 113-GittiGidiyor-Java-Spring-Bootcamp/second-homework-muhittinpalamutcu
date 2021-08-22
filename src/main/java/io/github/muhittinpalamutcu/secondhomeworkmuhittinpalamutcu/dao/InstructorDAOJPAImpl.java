package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Instructor;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.PermanentInstructor;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO<Instructor> {

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("from Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    public Instructor updateById(int id, Instructor instructor) {
        if (instructor instanceof PermanentInstructor) {
            PermanentInstructor permanentInstructor = entityManager.find(PermanentInstructor.class, id);

            permanentInstructor.setName(instructor.getName() == null ? permanentInstructor.getName() : instructor.getName());
            permanentInstructor.setAddress(instructor.getAddress() == null ? permanentInstructor.getAddress() : instructor.getAddress());
            permanentInstructor.setPhoneNumber(instructor.getPhoneNumber() == null ? permanentInstructor.getPhoneNumber() : instructor.getPhoneNumber());
            permanentInstructor.setFixedSalary(((PermanentInstructor) instructor).getFixedSalary() == 0 ? permanentInstructor.getFixedSalary() : ((PermanentInstructor) instructor).getFixedSalary());

            return entityManager.merge(permanentInstructor);
        } else if (instructor instanceof VisitingResearcher) {
            VisitingResearcher visitingResearcher = entityManager.find(VisitingResearcher.class, id);

            visitingResearcher.setName(instructor.getName() == null ? visitingResearcher.getName() : instructor.getName());
            visitingResearcher.setAddress(instructor.getAddress() == null ? visitingResearcher.getAddress() : instructor.getAddress());
            visitingResearcher.setPhoneNumber(instructor.getPhoneNumber() == null ? visitingResearcher.getPhoneNumber() : instructor.getPhoneNumber());
            visitingResearcher.setHourlySalary(((VisitingResearcher) instructor).getHourlySalary() == 0 ? visitingResearcher.getHourlySalary() : ((VisitingResearcher) instructor).getHourlySalary());

            return entityManager.merge(visitingResearcher);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Instructor.class, id));
    }
}
