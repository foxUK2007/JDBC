package sky.pro.maven_project;

import sky.pro.maven_project.models.Employee;

import sky.pro.maven_project.services.cityDao.CityDao;
import sky.pro.maven_project.services.cityDao.CityDaoImpl;
import sky.pro.maven_project.services.employeeDao.EmployeeDAO;
import sky.pro.maven_project.services.employeeDao.EmployeeDAOImpl;

import java.sql.*;

public class Application {


    private static CityDao cityDao = new CityDaoImpl();

    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private static void printEmployees() {
        for (Employee employee : employeeDAO.allEmployees())
            System.out.println(employee);
    }


    private static Object readEmployee(int id) {
        try {
            return employeeDAO.readEmployeeById(id);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private static void deleteEmployee(int id) {
        try {
            employeeDAO.deleteEmployee(employeeDAO.readEmployeeById(id));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateEmployee(Employee employee) {
        try {
            employeeDAO.readEmployeeById(employee.getId());
            employeeDAO.updateEmployee(employee);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        System.out.println(employeeDAO.readEmployeeById(8));
        Employee Anton = new Employee(20, "Антон", "Яковлев", "муж", 30, 9);
        employeeDAO.createEmployee(Anton);
        for (Employee employee : employeeDAO.allEmployees()) {
            System.out.println(employee);
        }
        Anton.setLast_name("Пучков");
        employeeDAO.updateEmployee(Anton);
        employeeDAO.deleteEmployee(Anton);
    }


}

