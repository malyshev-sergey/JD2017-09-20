package by.it.malyshev.jd03_03.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static volatile Connection connection = null;
    private static Properties dbSetting=new Properties();

    static {
        Driver driver;
        try { //регистрируем драйвер
//            Class.forName("com.mysql.cj.jdbc.Driver");
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            dbSetting.load(ConnectionCreator.class.getResourceAsStream("db_setting.ini"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    dbSetting.getProperty("URL_DB"),
                    dbSetting.getProperty("USER_DB"),
                    dbSetting.getProperty("PASSWORD_DB")
            );
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection cn=getConnection();
        if (!cn.isClosed())
            System.out.println("ok");

    }

}
