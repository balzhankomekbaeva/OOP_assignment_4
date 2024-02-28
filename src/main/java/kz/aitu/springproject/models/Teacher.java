package kz.aitu.springproject.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "teacher")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;
    @Column(name = "teacher_name")
    private String name;
    @Column(name = "teacher_surname")
    private String surname;
    @Column(name = "teacher_age")
    private int age;
    @Column(name = "teacher_email")
    private String email;

    @Override
    public String toString() {
        return id + " " +  name + " " + surname + " " + age + " " + email;
    }
}