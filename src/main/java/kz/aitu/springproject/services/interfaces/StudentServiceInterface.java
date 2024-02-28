package kz.aitu.springproject.services.interfaces;

import kz.aitu.springproject.models.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAll();
    Student getById(int id);
    Student create(Student student);
    Student update(Student student);

    void delete(int id);
}
