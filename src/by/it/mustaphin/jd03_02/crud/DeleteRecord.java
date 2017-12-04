package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
    Connection con;

    public DeleteRecord(Connection con) {
        this.con = con;
    }

    public boolean deleteUser(User user) throws SQLException {
        try (Statement st = con.createStatement()) {
            return (1 == st.executeUpdate("DELETE FROM users WHERE id_user='" + user.getId() + "';"));
        } catch (SQLException e) {
            throw e;
        }
    }
}
