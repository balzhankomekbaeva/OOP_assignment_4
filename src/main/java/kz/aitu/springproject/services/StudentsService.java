package kz.aitu.springproject.services;

import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.services.interfaces.StudentServiceInterface;

import java.util.List;

public class StudentsService implements StudentServiceInterface {
    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public List<Student> getBySurname(String surname) {
        return null;
    }
}
