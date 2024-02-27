package kz.aitu.springproject.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Enrollment")

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int student_id;
    private int course_id;


    @Override
    public String toString() {
        return id + " " + student_id + " " + course_id;
    }
}