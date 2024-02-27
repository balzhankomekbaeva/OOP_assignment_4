package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositoryInterface extends JpaRepository<Teacher, Integer> {
}
