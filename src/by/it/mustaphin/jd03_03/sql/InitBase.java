package by.it.mustaphin.jd03_03.sql;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InitBase {

    public static void main(String[ ] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(System.getProperty("user.dir") + "/src/by/it/mustaphin/jd03_03/connection/dbConnection.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(prop.getProperty("urlUnsigned"), prop.getProperty("login"), prop.getProperty("password")); Statement st = con.createStatement();) {
            st.executeUpdate("DROP SCHEMA IF EXISTS `mustaphin`;");
            st.executeUpdate("CREATE DATABASE  IF NOT EXISTS `mustaphin` DEFAULT CHARACTER SET utf8;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
