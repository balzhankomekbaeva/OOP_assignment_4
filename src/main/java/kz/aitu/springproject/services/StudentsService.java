package kz.aitu.springproject.services;

import kz.aitu.springproject.models.Student;
import kz.aitu.springproject.repositories.StudentRepositoryInterface;
import kz.aitu.springproject.services.interfaces.StudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentsService implements StudentServiceInterface {
    private final StudentRepositoryInterface repo;

    public StudentsService(StudentRepositoryInterface repo)
    {
        this.repo = repo;
    }
    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getBySurname(String surname) {
        return null;
    }
}
