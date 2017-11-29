package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
    Connection con;

    public UpdateRecord(Connection con) {
        this.con = con;
    }

    public User updateUser(User user) throws SQLException {
        User updUser = null;
        try (Statement st = con.createStatement()) {
            if (1 == st.executeUpdate("UPDATE users SET login='" + user.getName() + "', password='" + user.getLogin() + "' , name='" + user.getPassword() + "' WHERE id_user='" + user.getId() + "';")) {
                updUser = user;
            }
        } catch (SQLException e) {
            throw e;
        }
        return updUser;
    }
}
