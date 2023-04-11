package sky.pro.maven_project.services.employeeDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.pro.maven_project.connections.HibernateSessionFactoryUtil;
import sky.pro.maven_project.models.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readEmployeeById(int id) {
        Employee employee = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);

        if (employee != null) {
            return employee;
        } else {
            throw new RuntimeException("В базе данных такого работника не существует.");
        }
    }


    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public List<Employee> allEmployees() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Employee> employees = session.createQuery("FROM Employee").list();
            if (!employees.isEmpty()) {
                return employees;
            } else {
                throw new RuntimeException("Список работников в базе данных пуст.");
            }
        }
    }
}

