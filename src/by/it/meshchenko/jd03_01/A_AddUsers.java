package by.it.meshchenko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class A_AddUsers {
    public static void main(String[ ] args) {
//        //наболее надежный способ загрузки драйвера
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//        //второй способ загрузки драйвера
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {e.printStackTrace();}
        //в некоторых случаях можно вообще ничего не загружать
        // (например при запуске в IDEA)
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into crm_users(" +
                            "`Name`,`Password`,`Email`)"+
                            " values('Guru','12345','guru@guru.ru');"
            );
            statement.executeUpdate(
                    "insert into crm_users(" +
                            "`Name`,`Password`,`Email`)"+
                            " values('User1','1234','user2@gmail.com');"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
