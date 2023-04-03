package sky.pro.maven_project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;

    @Column(name = "city_id")
    private int city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(first_name, employee.first_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name);
    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "Имя: " + first_name + ", " +
                "Фамилия: " + last_name + ", " +
                "Пол: " + gender + ", " +
                "Возраст: " + age;
    }
}
