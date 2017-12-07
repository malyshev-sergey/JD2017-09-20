package by.it.likhanau.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    Connection con;

    public A_AddUser(Connection con) {
        this.con = con;
    }

    void addUser() {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `likhanau`.`users` (`id_role`, `login`, `password`) VALUES ('2', 'Lila1', 'qwe123');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
