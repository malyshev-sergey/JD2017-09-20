package by.it.malyshev.project.java.connection;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static volatile Connection connection = null;
//    private static Properties dbSetting=new Properties();

    @Resource(name = "jdbc/my_sql_malyshev")
    private static DataSource ds;

    static {
        Driver driver;
        try { //регистрируем драйвер
//            Class.forName("com.mysql.cj.jdbc.Driver");
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

//            dbSetting.load(ConnectionCreator.class.getResourceAsStream("db_setting.ini"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionOld() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
/*                    dbSetting.getProperty("URL_DB"),
                    dbSetting.getProperty("USER_DB"),
                    dbSetting.getProperty("PASSWORD_DB")*/

                    "jdbc:mysql://127.0.0.1:3306/malyshev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&useSSL=false",
                    "malyshev",
                    "malyshev"
            );
        return connection;
    }

    public static Connection getConnection() {
        try {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/my_sql_malyshev");

            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection cn=getConnection();
        if (!cn.isClosed())
            System.out.println("ok");

    }

}
