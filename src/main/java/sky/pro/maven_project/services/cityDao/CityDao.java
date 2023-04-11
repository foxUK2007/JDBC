package sky.pro.maven_project.services.cityDao;

import sky.pro.maven_project.models.City;

import java.sql.SQLException;

public interface CityDao {

    City readCityById(int id);

    void deleteCity(City city);

    void updateCity(City city);

    void createCity(City city);
}
