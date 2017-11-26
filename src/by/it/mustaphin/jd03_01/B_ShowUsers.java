package by.it.mustaphin.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    Connection con;

    public B_ShowUsers(Connection con) {
        this.con = con;
    }

    void getData() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users;");
            ResultSetMetaData rsmd = rs.getMetaData();
            int coluns = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 2; i <= coluns; i++) {
                    System.out.println(rsmd.getColumnLabel(i) + " : " + rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
