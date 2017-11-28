package by.it.meshchenko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[ ] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            ////пересоздание базы целиком
            //statement.executeUpdate("DROP SCHEMA IF EXISTS `meshchenko` ;");
            //statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `meshchenko` DEFAULT CHARACTER SET utf8 ;");

            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_countries` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_cities` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_streets` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`addr_addresses` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`crm_users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_shoppingcenters` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_rooms` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `meshchenko`.`ls_leaserooms` ;");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
