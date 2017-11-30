package by.it.mustaphin.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CreateRecord {
    Connection con;

    public CreateRecord(Connection con) {
        this.con = con;
    }

    public User createUser(User user) throws SQLException {
        user.setId(0);
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        int fk_question = user.getFk_question();
        try (Statement st = con.createStatement()) {
            if (1 == st.executeUpdate("INSERT INTO users (name, login, password, fk_question) VALUES ('" + name + "', '" + login + "', '" + password + "','" + fk_question + "');", RETURN_GENERATED_KEYS)) {
                ResultSet keys = st.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
