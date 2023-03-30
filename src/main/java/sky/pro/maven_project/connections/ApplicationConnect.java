package sky.pro.maven_project.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnect {

    private Connection getConnection() throws SQLException {

        final String user = "postgres";

        final String password = "fox38";

        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
