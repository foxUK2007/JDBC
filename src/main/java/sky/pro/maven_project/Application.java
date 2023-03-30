package sky.pro.maven_project;

import sky.pro.maven_project.models.Employee;
import sky.pro.maven_project.models.City;
import sky.pro.maven_project.services.cityDao.CityDao;
import sky.pro.maven_project.services.cityDao.CityDaoImpl;
import sky.pro.maven_project.services.employeeDao.EmployeeDAO;
import sky.pro.maven_project.services.employeeDao.EmployeeDAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static CityDao cityDao = new CityDaoImpl();

    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    public static void main(String[] args) throws SQLException {
        //Задание 2
        System.out.println(cityDao.readCityById(6));

        System.out.println(employeeDAO.readEmployeeById(14));

       employeeDAO.createEmployee(18, "Иван", "Селин", "муж", 35, 9);

       employeeDAO.updateEmployee(8, "Игорь", "Карев", "муж", 47, 6);

        employeeDAO.deleteEmployee(16);

        for (Employee employee: employeeDAO.allEmployees()){
            System.out.println(employee);
        }

        //Задание 1

        final String user = "postgres";

        final String password = "fox38";

        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")) {

            statement.setInt(1, 16);
            statement.execute();

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int sity_id = resultSet.getInt("sity_id");

                System.out.println("id: " + id);
                System.out.println("Имя: " + first_name);
                System.out.println("Фамилия: " + last_name);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст: " + age);
                System.out.println("Город: " + sity_id);
                System.out.println("--------------------");

            }

        }

    }


}
