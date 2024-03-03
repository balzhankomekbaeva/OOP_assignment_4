package kz.aitu.springproject.services.interfaces;
import kz.aitu.springproject.models.Courses;
import java.util.List;

public interface CourseServiceInterface {
    List<Courses> getAll();
    Courses getById(int id);
    Courses create(Courses courses);
    Courses update(Courses courses);
    void delete(int id);
}
