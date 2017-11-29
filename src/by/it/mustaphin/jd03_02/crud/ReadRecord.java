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

    void readUser(String id) {
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id_user='" + id + "';");
            System.out.print("id пользоывателя: " + id);
            if (rs.next()) {
                System.out.printf("имя %s, логин %s, пароль %s, вн. ключ текщего прогресса %s",
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("fk_question"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
