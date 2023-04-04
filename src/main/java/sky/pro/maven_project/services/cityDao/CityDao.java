package sky.pro.maven_project.services.cityDao;

import sky.pro.maven_project.models.City;

import java.sql.SQLException;

public interface CityDao {


    City readCityById(int id);
}
