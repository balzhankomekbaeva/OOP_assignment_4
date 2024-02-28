package kz.aitu.springproject.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name = "enrollment", schema = "public")

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private int id;
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "course_id")
    private int course_id;


    @Override
    public String toString() {
        return id + " " + student_id + " " + course_id;
    }
}