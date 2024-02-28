package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.services.interfaces.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class StudentController {
    private final StudentServiceInterface service;

    public StudentController(StudentServiceInterface service)
    {
        this.service = service;
    }
    @GetMapping("allStudents")
    public List<Student> getAll() {
        return service.getAll();
    }
    @GetMapping("/{student_id}")
    public ResponseEntity<Student> getById(@PathVariable("student_id") int id)
    {
        Student student = service.getById(id);
        if(student == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
        return new ResponseEntity<>(student, HttpStatus.OK); //200
    }
    @PostMapping("createStudent")
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student createdStudent = service.create(student);
        if(createdStudent == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED); //201
    }
}