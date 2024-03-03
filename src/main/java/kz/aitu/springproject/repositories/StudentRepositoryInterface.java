package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {
    List<Student> findBySurname(String surname);

    Student findByEmail(String email);
}