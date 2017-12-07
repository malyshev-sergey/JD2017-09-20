package by.it.likhanau.jd03_03.connection;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static volatile Connection connection = null;
    private static Properties dbSetting=new Properties();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbSetting.load(ConnectionCreator.class.getResourceAsStream("db_setting.ini"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
