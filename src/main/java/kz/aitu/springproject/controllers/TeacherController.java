package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("app")
public class TeacherController {
    private final TeacherServiceInterface service;

    public TeacherController(TeacherServiceInterface service)
    {
        this.service = service;
    }
    @GetMapping("AllTeacher")
    public List<Teacher> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/teacherById/{teacher_id}")
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
    @PutMapping("/updateTeacher/{teacher_id}")
    public Teacher update(@PathVariable int teacher_id, @RequestBody Teacher teacher)
    {
        teacher.setId(teacher_id);
        return service.update(teacher);
    }
    @DeleteMapping("/deleteTeacher")
    public void delete(@RequestParam int teacher_id)
    {
        service.delete(teacher_id);
    }

    @GetMapping("/getTeacherBySurname/{teacher_surname}")
    public List<Teacher> getBySurname(@PathVariable("teacher_surname") String teacher_surname)
    {
        return service.getBySurname(teacher_surname);
    }
}
