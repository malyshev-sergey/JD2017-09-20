package by.it.likhanau.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class B_ShowUsers {
    Connection con;

    public B_ShowUsers(Connection con) {
        this.con = con;
    }

    void showUsers() {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("USE likhanau");
            ResultSet rs = statement.executeQuery("SELECT id_user, login, password, id_role FROM users");
            while (rs.next()) {
                String role = magicFun("SELECT role FROM roles WHERE id_role = " + rs.getString("id_role"), "role");
                System.out.println(rs.getString("login") + " is a " + role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized String magicFun(String query, String field) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        try {
            if (rs.next()) {
                return rs.getString(field);
            } else
                return null;
        } catch (Exception e) {
            System.out.println("Во время выполнения единичного запроса '" + query + "' к БД произошла ошибка");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
