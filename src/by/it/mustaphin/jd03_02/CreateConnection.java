package by.it.mustaphin.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {

    private static volatile Connection connection = null;
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(new FileReader(System.getProperty("user.dir") + "/src/by/it/mustaphin/jd03_02/dbConnection.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (null == connection || connection.isClosed()) {
            try {
                Driver dr = new FabricMySQLDriver();
                DriverManager.registerDriver(dr);
                synchronized (prop) {
                    if (null == connection || connection.isClosed()) {
                        connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("login"), prop.getProperty("password"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }
}
