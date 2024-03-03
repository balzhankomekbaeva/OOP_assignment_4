package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepositoryInterface extends JpaRepository<Teacher, Integer>
{
    List<Teacher> findBySurname(String surname);
}
