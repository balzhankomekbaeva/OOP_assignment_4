package kz.aitu.springproject.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Teacher")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String surname;
    private String name;
    private int age;
    private String email;

    @Override
    public String toString() {
        return id + " " +  name + " " + surname + " " + age + " " + email;
    }
}