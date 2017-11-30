package by.it.mustaphin.jd03_02.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                        rs.getInt("id_user"),
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

    public List<User> readAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement st = con.createStatement()) {
            final ResultSet rs = st.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("fk_question"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw e;
        }
        return users;
    }

    public List<String> findIdRole(String userName) {
        List<String> roles = new ArrayList<>();
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SELECT id_role FROM users_has_roles WHERE id_user=(SELECT id_user FROM users WHERE name='" + userName + "');")) {
            while (rs.next()) {
                roles.add(rs.getString("id_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public int[] getTotal() {
        int[] total = new int[2];
        try (Statement st = con.createStatement()) {
            total[0] = readAllUsers().size();
            ResultSet rs = st.executeQuery("SELECT COUNT(id_role) FROM roles;");
            if(rs.next())
            total[1] = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
