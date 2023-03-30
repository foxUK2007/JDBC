package sky.pro.maven_project.services.cityDao;

import sky.pro.maven_project.connections.ApplicationConnect;
import sky.pro.maven_project.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {

    private final ApplicationConnect applicationConnect = new ApplicationConnect();

    @Override
    public City readCityById(int id) throws SQLException {
        try(PreparedStatement statement =
                    applicationConnect.getPreparedStatement
                            ("SELECT * FROM sity WHERE sity_id = (?)")){
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new City(resultSet.getString("sity_name"));

        }
    }
}
