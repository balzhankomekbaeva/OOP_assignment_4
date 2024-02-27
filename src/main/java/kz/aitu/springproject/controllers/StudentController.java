package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.services.interfaces.StudentServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
