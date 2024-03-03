package kz.aitu.springproject.repositories;

import kz.aitu.springproject.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepositoryInterface extends JpaRepository<Enrollment, Integer> {

}
