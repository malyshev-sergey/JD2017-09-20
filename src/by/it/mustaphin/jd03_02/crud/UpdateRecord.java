package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
    Connection con;

    public UpdateRecord(Connection con) {
        this.con = con;
    }

    boolean updateUser(String id, String name, String login, String password) {
        try (Statement st = con.createStatement()) {
            return (1 == st.executeUpdate("UPDATE users SET login='" + name + "', password='" + login + "' , name='" + name + "' WHERE id_user='" + id + "';"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
