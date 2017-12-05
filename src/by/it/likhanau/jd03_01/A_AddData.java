package by.it.likhanau.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    Connection con;

    public A_AddData(Connection con) {
        this.con = con;
    }

    void addData() {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO `likhanau`.`roles` (`role`) VALUES ('buyer');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
