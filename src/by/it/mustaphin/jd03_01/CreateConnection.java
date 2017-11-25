package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    Connection connection;

    CreateConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (null == connection) {
                connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            }
            System.out.println("DB connected");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
