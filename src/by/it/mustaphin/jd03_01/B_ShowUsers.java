package by.it.mustaphin.jd03_01;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<Integer, String> users = new HashMap<>();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i <= coluns; i++) {
                    sb.append(rsmd.getColumnLabel(i) + " : " + rs.getString(i) + "\n");
                }
                users.put(rs.getInt("id_user"), sb.toString());
            }
            for (Map.Entry<Integer, String> user : users.entrySet()) {
                ResultSet rsId = st.executeQuery("SELECT id_role FROM users_has_roles WHERE id_user='" + user.getKey() + "';");
                List<String> rolesId = new ArrayList<>();
                while (rsId.next()) {
                    rolesId.add(rsId.getString("id_role"));
                }
                rsId.close();
                StringBuilder userSb = new StringBuilder();
                for (String id : rolesId) {
                    ResultSet rsRole = st.executeQuery("SELECT type FROM roles WHERE id_role='" + id + "';");
                    if (rsRole.next()) {
                        userSb.append("роль: " + rsRole.getString("type") + "\n");
                    }
                }
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.print(user.getValue());
                System.out.print(userSb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
