package by.it.mustaphin.jd03_02;

import by.it.mustaphin.jd03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {

        Connection con = null;
        try {
            con = CreateConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TaskA tA = new TaskA(con);
        tA.findIdRole("mustaphin marat");

        CreateRecord cr = new CreateRecord(con);
        ReadRecord rr = new ReadRecord(con);
        UpdateRecord ur = new UpdateRecord(con);
        DeleteRecord dr = new DeleteRecord(con);

        try {
            User user = cr.createUser(new User("newName", "newLogin", "newPassword", 0));
            rr.readUser(user.getId());

            user = ur.updateUser(user);
            rr.readUser(user.getId());

            if (dr.deleteUser(user)) {
                System.out.println("Пользователь c id " + user.getId() + " удалён");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
