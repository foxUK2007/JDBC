package sky.pro.maven_project.models;

import java.util.Objects;

public class Employee {

    private int id;

    private String first_name;

    private String last_name;

    private String gender;
    private int age;

    private City city;

    public Employee(int id, String first_name, String last_name, String gender, int age, City city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee() {
    }

    public Employee(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



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
                "Возраст: " + age + ", " + city;
    }
}
