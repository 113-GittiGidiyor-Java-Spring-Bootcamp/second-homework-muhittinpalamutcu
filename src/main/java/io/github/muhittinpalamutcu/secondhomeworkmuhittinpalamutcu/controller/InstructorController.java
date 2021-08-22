package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.controller;

import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.Instructor;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.PermanentInstructor;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model.VisitingResearcher;
import io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    //Dependency injection via constructor
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // @desc Get all instructors
    // @route Get /api/instructors
    // @access Public
    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAllInstructors() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    // @desc Record new permanent instructor
    // @route Post /api/instructors/permanentInstructor
    // @access Public
    @PostMapping("/instructors/permanentInstructors")
    public PermanentInstructor savePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor) {
        return (PermanentInstructor) instructorService.save(permanentInstructor);
    }

    // @desc Record new visiting researcher
    // @route Post /api/instructors/visitingResearcher
    // @access Public
    @PostMapping("/instructors/visitingResearcher")
    public VisitingResearcher saveVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher) {
        return (VisitingResearcher) instructorService.save(visitingResearcher);
    }

    // @desc Get permanent instructor information by id
    // @route Get /api/instructors/permanentInstructor/{id}
    // @access Public
    @GetMapping("/instructors/permanentInstructors/{id}")
    public PermanentInstructor findPermanentInstructorById(@PathVariable int id) {
        return (PermanentInstructor) instructorService.findById(id);
    }

    // @desc Get visiting researcher information by id
    // @route Get /api/instructors/visitingResearcher/{id}
    // @access Public
    @GetMapping("/instructors/visitingResearcher/{id}")
    public VisitingResearcher findVisitingResearcherById(@PathVariable int id) {
        return (VisitingResearcher) instructorService.findById(id);
    }

    // @desc Update permanent instructor information by id
    // @route Put /api/instructors/permanentInstructor/{id}
    // @access Public
    @PutMapping("/instructors/permanentInstructors/{id}")
    public PermanentInstructor updatePermanentInstructorById(@PathVariable int id, @RequestBody PermanentInstructor permanentInstructor) {
        return (PermanentInstructor) instructorService.updateById(id, permanentInstructor);
    }

    // @desc Update visiting researcher information by id
    // @route Put /api/instructors/visitingResearcher/{id}
    // @access Public
    @PutMapping("/instructors/visitingResearcher/{id}")
    public VisitingResearcher updateVisitingResearcherById(@PathVariable int id, @RequestBody VisitingResearcher visitingResearcher) {
        return (VisitingResearcher) instructorService.updateById(id, visitingResearcher);
    }

    // @desc Delete instructor by id
    // @route Delete /api/instructors/{id}
    // @access Public
    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable int id) {
        instructorService.deleteById(id);
        return new ResponseEntity<>("Instructor deleted succesfully...", HttpStatus.OK);
    }

}
