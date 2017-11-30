package by.it.mustaphin.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {
    Connection con;

    public TaskA(Connection con) {
        this.con = con;
    }

    void findIdRole(String userName) {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id_role FROM users_has_roles WHERE id_user=(SELECT id_user FROM users WHERE name='" + userName + "');")) {
            System.out.print("\"" + userName + "\" has role:");
            while (rs.next()) {
                System.out.print(" " + rs.getString("id_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
