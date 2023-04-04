package sky.pro.maven_project.services.employeeDao;

import sky.pro.maven_project.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee readEmployeeById(int id);

    void deleteEmployee(Employee employee);

    void updateEmployee(Employee employee);

    List<Employee> allEmployees();
}
