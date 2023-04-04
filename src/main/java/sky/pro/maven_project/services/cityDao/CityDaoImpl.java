package sky.pro.maven_project.services.cityDao;

import sky.pro.maven_project.connections.HibernateSessionFactoryUtil;
import sky.pro.maven_project.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
