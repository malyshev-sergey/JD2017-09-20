package by.it.mustaphin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    Connection con;

    public A_AddData(Connection con) {
        this.con = con;
    }

    void updateCurrentPosition(int position, int id_user) {
        try {
            Statement st = con.createStatement();
            int success = st.executeUpdate("UPDATE users SET fk_question='" + position + "' WHERE id_user='" + id_user + "';");
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
