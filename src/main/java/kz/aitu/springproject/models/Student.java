package kz.aitu.springproject.models;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "Student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " age: " + age + " " + email;
    }
}