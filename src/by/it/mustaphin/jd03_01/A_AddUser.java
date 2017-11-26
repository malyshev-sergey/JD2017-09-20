package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    Connection con;

    public A_AddUser(Connection con) {
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.con = con;
    }

    void addUser() {
        try {
            Statement st = con.createStatement();
            int success = st.executeUpdate("INSERT INTO users (name, login, password, fk_question) VALUES ('some', 'any', '0000', '2');");
            success += st.executeUpdate("INSERT INTO mustaphin.users_has_roles (id_user, id_role) VALUES ('1', '3');");
            if (2 == success) {
                con.commit();
                System.out.println("Запись успешно добавлена");
            } else {
                System.out.println("Ошибка записи в БД");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != con) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
