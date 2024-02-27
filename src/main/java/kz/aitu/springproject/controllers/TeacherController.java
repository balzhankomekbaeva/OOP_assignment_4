package kz.aitu.springproject.controllers;
import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.services.interfaces.TeacherServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
