package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    Connection con;

    C_Reset(Connection con) {
        this.con = con;
    }

    void removeAll() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DROP TABLE mustaphin.answers_catalog;");
            st.executeUpdate("DROP TABLE mustaphin.questions;");
            st.executeUpdate("DROP TABLE mustaphin.roles;");
            st.executeUpdate("DROP TABLE mustaphin.users;");
            st.executeUpdate("DROP TABLE mustaphin.users_has_roles;");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
