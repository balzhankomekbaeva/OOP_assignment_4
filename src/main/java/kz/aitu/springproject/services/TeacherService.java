package kz.aitu.springproject.services;

import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.repositories.TeacherRepositoryInterface;
import kz.aitu.springproject.services.interfaces.TeacherServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements TeacherServiceInterface {
    private final TeacherRepositoryInterface repo;

    public TeacherService(TeacherRepositoryInterface repo)
    {
        this.repo = repo;
    }
    @Override
    public List<Teacher> getAll() {
        return repo.findAll();
    }

    @Override
    public Teacher getById(int id) {
        return null;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return null;
    }

    @Override
    public List<Teacher> getBySurname(String surname) {
        return null;
    }
}
