package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Courses;
import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.services.CourseRequest;
import kz.aitu.springproject.services.interfaces.CourseServiceInterface;
import kz.aitu.springproject.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class CourseController
{
    private final CourseServiceInterface service;
    private final TeacherServiceInterface tservice;

    public CourseController(CourseServiceInterface service, TeacherServiceInterface tservice)
    {
        this.service = service;
        this.tservice = tservice;
    }
    @GetMapping("allCourses")
    public List<Courses> getAll() {
        return service.getAll();
    }
    @GetMapping("/courseById/{course_id}")
    public ResponseEntity<Courses> getById(@PathVariable("course_id") int id)
    {
        Courses courses = service.getById(id);
        if(courses == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);

    }
    @PostMapping("createCourse")
    public ResponseEntity<Courses> create(@RequestBody CourseRequest courseRequest){
        Teacher teacher = tservice.getById(courseRequest.getTeacherId());
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Courses courses = new Courses();
        courses.setName(courseRequest.getCourseName());
        courses.setTeacher(teacher);
        Courses createdCourse = service.create(courses);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }
    @PutMapping("/updateCourse/{course_id}")
    public Courses update(@PathVariable int course_id, @RequestBody CourseRequest courseRequest)
    {
        Teacher teacher = tservice.getById(courseRequest.getTeacherId());
        Courses courses = new Courses();
        courses.setId(course_id);
        courses.setName(courseRequest.getCourseName());
        courses.setTeacher(teacher);
        return service.update(courses);
    }

}
