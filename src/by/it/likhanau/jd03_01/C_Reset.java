package by.it.likhanau.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    Connection con;

    public C_Reset(Connection con) {
        this.con = con;
    }

    void initDB() {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS `users`");
            statement.executeUpdate("DROP TABLE IF EXISTS `roles`");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

