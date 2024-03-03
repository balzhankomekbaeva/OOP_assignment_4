package kz.aitu.springproject.services.interfaces;

import kz.aitu.springproject.models.Courses;
import kz.aitu.springproject.models.Enrollment;

import java.util.List;

public interface EnrollmentServiceInterface {
    List<Enrollment> getAll();
    Enrollment getById(int id);
    Enrollment create(Enrollment enrollment);
    Enrollment update(Enrollment enrollment);
    void delete(int id);
}
