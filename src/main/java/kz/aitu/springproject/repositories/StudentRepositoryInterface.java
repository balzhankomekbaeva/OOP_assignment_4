package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {

}