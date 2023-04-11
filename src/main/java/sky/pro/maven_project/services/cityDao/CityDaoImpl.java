package sky.pro.maven_project.services.cityDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.pro.maven_project.connections.HibernateSessionFactoryUtil;
import sky.pro.maven_project.models.City;

public class CityDaoImpl implements CityDao {

    @Override
    public City readCityById(int id) {
        City city = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);

        if (city != null) {
            return city;
        } else {
            throw new RuntimeException("В базе данных такой город не существует.");
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }


    @Override
    public void createCity(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }
}
