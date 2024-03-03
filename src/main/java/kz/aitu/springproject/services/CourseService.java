package kz.aitu.springproject.services;

import kz.aitu.springproject.models.Courses;
import kz.aitu.springproject.models.Teacher;
import kz.aitu.springproject.repositories.CourseRepositoryInterface;
import kz.aitu.springproject.repositories.TeacherRepositoryInterface;
import kz.aitu.springproject.services.interfaces.CourseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {
    private CourseRepositoryInterface repo;
    public CourseService(CourseRepositoryInterface repo, TeacherRepositoryInterface trepo)
    {
        this.repo = repo;
    }

    @Override
    public List<Courses> getAll() {
        return repo.findAll();
    }

    @Override
    public Courses getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Courses create(Courses courses) {
        return repo.save(courses);
    }

    @Override
    public Courses update(Courses courses) {
        return repo.save(courses);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
