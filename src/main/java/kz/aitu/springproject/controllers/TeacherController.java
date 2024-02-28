package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class TeacherController {
    private TeacherServiceInterface service;

    public TeacherController(TeacherServiceInterface service)
    {
        this.service = service;
    }
    @GetMapping("AllTeacher")
    public List<Teacher> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{teacher_id}")
    public ResponseEntity<Teacher> getById(@PathVariable("teacher_id") int id)
    {
        Teacher teacher = service.getById(id);
        if(teacher == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK); //200
    }
    @PostMapping("createTeacher")
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
        Teacher createdTeacher = service.create(teacher);
        if(createdTeacher == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED); //201
    }

}
