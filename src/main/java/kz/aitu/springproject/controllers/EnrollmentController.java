package kz.aitu.springproject.controllers;

import kz.aitu.springproject.models.Courses;
import kz.aitu.springproject.models.Enrollment;
import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.services.EnrollmentRequest;
import kz.aitu.springproject.services.interfaces.CourseServiceInterface;
import kz.aitu.springproject.services.interfaces.EnrollmentServiceInterface;
import kz.aitu.springproject.services.interfaces.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class EnrollmentController {
    private final EnrollmentServiceInterface service;
    private final CourseServiceInterface cservice;

    private final StudentServiceInterface sservice;
    public EnrollmentController(CourseServiceInterface cservice, StudentServiceInterface sservice, EnrollmentServiceInterface service)
    {
        this.service = service;
        this.cservice = cservice;
        this.sservice = sservice;
    }
    @GetMapping("allEnrollments")
    public List<Enrollment> getAll() {
        return service.getAll();
    }
    @GetMapping("/enrollmentById/{enrollment_id}")
    public ResponseEntity<Enrollment> getById(@PathVariable("enrollment_id") int id)
    {
        Enrollment enrollment = service.getById(id);
        if(enrollment == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enrollment, HttpStatus.OK);

    }
    @PostMapping("createEnrollment")
    public ResponseEntity<Enrollment> create(@RequestBody EnrollmentRequest enrollmentRequest){
        Student student = sservice.getById(enrollmentRequest.getStudentId());
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Courses courses = cservice.getById(enrollmentRequest.getCourseId());
        if(courses == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setCourses(courses);
        enrollment.setStudent(student);
        Enrollment createdEnrollment = service.create(enrollment);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }
    @PutMapping("/updateEnrollment/{enrollment_id}")
    public Enrollment update(@PathVariable int enrollment_id, @RequestBody EnrollmentRequest enrollmentRequest)
    {
        Courses courses = cservice.getById(enrollmentRequest.getCourseId());
        Student student = sservice.getById(enrollmentRequest.getStudentId());

        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollment_id);
        enrollment.setStudent(student);
        enrollment.setCourses(courses);
        return service.update(enrollment);
    }

}

