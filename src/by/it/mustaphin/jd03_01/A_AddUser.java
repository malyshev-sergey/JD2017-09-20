package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    Connection con;

    public A_AddUser(Connection con) {
        this.con = con;
    }

    void addUser() {
        try {
            Statement st = con.createStatement();
            int success = st.executeUpdate("INSERT INTO users (name, login, password, fk_question, fk_role) VALUES ('some', 'any', '0000', '2', '2');");
            if (1 == success) {
                System.out.println("Запись успешно добавлена");
            }
            if (null != con) {
                con = null;
            } else {
                System.out.println("Ошибка записи в БД");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
