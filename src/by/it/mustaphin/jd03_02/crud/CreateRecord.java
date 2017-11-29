package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateRecord {
    Connection con;

    public CreateRecord(Connection con) {
        this.con = con;
    }

    boolean createUser(String name, String login, String password) {
        try (Statement st = con.createStatement()) {
            return (1 == st.executeUpdate("INSERT INTO users (name, login, password) VALUES ('" + name + "', '" + login + "', '" + password + "');"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
