package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadRecord {
    Connection con;

    public ReadRecord(Connection con) {
        this.con = con;
    }

    public User readUser(int id) throws SQLException {
        User user = null;
        try (Statement st = con.createStatement()) {
            final ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id_user='" + id + "';");
            if (rs.next()) {
                user = new User(
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("fk_question"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }
}
