package kz.aitu.springproject.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Courses", schema = "public")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "teacher_id")
    private int teacher_id;

    @Override
    public String toString() {
        return id + " " + courseName + " " + teacher_id;
    }
}