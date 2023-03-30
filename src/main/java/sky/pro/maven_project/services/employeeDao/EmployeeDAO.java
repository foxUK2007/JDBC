package sky.pro.maven_project.services.employeeDao;

import sky.pro.maven_project.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(int id, String first_name, String last_name, String gender, int age, int sity_id) throws SQLException;

    Employee readEmployeeById(int id) throws SQLException;

    void deleteEmployee(int id) throws SQLException;

    void updateEmployee(int id, String first_name, String last_name, String gender, int age, int sity_id) throws SQLException;

    List<Employee> allEmployees() throws SQLException;
}
