package sky.pro.maven_project.services.employeeDao;

import sky.pro.maven_project.connections.ApplicationConnect;
import sky.pro.maven_project.models.Employee;
import sky.pro.maven_project.services.cityDao.CityDao;
import sky.pro.maven_project.services.cityDao.CityDaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final ApplicationConnect applicationConnect = new ApplicationConnect();

    private final CityDao cityDao = new CityDaoImpl();


    @Override
    public void deleteEmployee(int id) throws SQLException {

        try (PreparedStatement statement =
                     applicationConnect.getPreparedStatement
                             ("DELETE FROM employee  WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeQuery();

        }
    }

    @Override
    public void updateEmployee(int id, String first_name, String last_name, String gender, int age, int sity_id) throws SQLException {

        try (PreparedStatement statement =
                     applicationConnect.getPreparedStatement
                             ("UPDATE employee SET first_name = ?, last_name = ?, gender = ?, age = ?, sity_id = ? WHERE id = (?)")) {
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setInt(5, sity_id);
            statement.setInt(6, id);
            statement.executeQuery();

        }
    }


    @Override
    public Employee readEmployeeById(int id) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnect.getPreparedStatement
                             ("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new Employee(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("age"),
                    cityDao.readCityById(resultSet.getInt("sity_id")));

        }

    }


    @Override
    public void createEmployee(int id, String first_name, String last_name, String gender, int age, int sity_id) throws
            SQLException {

        try (PreparedStatement statement =
                     applicationConnect.getPreparedStatement
                             ("INSERT INTO employee (id, first_name, last_name, gender, age, sity_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, first_name);
            statement.setString(3, last_name);
            statement.setString(4, gender);
            statement.setInt(5, age);
            statement.setInt(6, sity_id);
            statement.executeQuery();

        }
    }

    @Override
    public List<Employee> allEmployees() throws SQLException {
        try (PreparedStatement statement =
                     applicationConnect.getPreparedStatement
                             ("SELECT * FROM employee;")) {
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        cityDao.readCityById(resultSet.getInt("sity_id"))));
            }
            return employees;
        }
    }
}

