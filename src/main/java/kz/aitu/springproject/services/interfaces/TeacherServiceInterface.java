package kz.aitu.springproject.services.interfaces;
import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.models.Teacher;

import java.util.List;

public interface TeacherServiceInterface {
    List<Teacher> getAll();
    Teacher getById(int id);
    Teacher create(Teacher teacher);
    List<Teacher> getBySurname(String surname);
    Teacher update(Teacher teacher);
    void delete(int id);
}
