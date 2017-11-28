package by.it.meshchenko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class B_AddRoles {
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
            int admin = 0, manager = 0, user = 0;
            //вставляем пользователей
            if(1 == statement.executeUpdate("insert into crm_roles(`Role`) values('admin');",
                    Statement.RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    admin = key.getInt(1);
                }
            }
            if(1 == statement.executeUpdate("insert into crm_roles(`Role`) values('manager');",
                    Statement.RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    manager = key.getInt(1);
                }
            }
            if(1 == statement.executeUpdate("insert into crm_roles(`Role`) values('user');",
                    Statement.RETURN_GENERATED_KEYS)) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()){
                    user = key.getInt(1);
                }
            }

            statement.executeUpdate("update crm_users set `RoleId` = " + admin
                    +" where Email = 'guruAdmin@guru.ru';");
            statement.executeUpdate("update crm_users set `RoleId` = " + manager
                    +" where Email = 'userManager1@gmail.com';");
            statement.executeUpdate("update crm_users set `RoleId` = " + user
                    +" where Email = 'user1@gmail.com';");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
