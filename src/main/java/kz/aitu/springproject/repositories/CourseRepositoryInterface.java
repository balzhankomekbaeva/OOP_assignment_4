package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoryInterface extends JpaRepository<Courses, Integer> {
}
