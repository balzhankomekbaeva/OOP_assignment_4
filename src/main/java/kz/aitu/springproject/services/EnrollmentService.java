package kz.aitu.springproject.services;

import kz.aitu.springproject.models.Courses;
import kz.aitu.springproject.models.Enrollment;
import kz.aitu.springproject.repositories.EnrollmentRepositoryInterface;
import kz.aitu.springproject.services.interfaces.EnrollmentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService implements EnrollmentServiceInterface {
    private EnrollmentRepositoryInterface repo;

    public EnrollmentService(EnrollmentRepositoryInterface repo)
    {
        this.repo = repo;
    }
    @Override
    public List<Enrollment> getAll() {
        return repo.findAll();
    }

    @Override
    public Enrollment getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
