package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
    Connection con;

    public DeleteRecord(Connection con) {
        this.con = con;
    }

    boolean deleteUser(String id) {
        try (Statement st = con.createStatement()) {
            return (1 == st.executeUpdate("DELETE FROM users WHERE id_user='" + id + "';"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
