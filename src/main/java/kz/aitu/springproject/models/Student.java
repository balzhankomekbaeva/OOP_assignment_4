package kz.aitu.springproject.models;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_surname")
    private String surname;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_email")
    private String email;

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " age: " + age + " " + email;
    }
}