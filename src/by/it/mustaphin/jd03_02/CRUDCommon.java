package by.it.mustaphin.jd03_02;

import by.it.mustaphin.jd03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CRUDCommon {

    public CRUDCommon(Connection con) {
        cr = new CreateRecord(con);
        ur = new UpdateRecord(con);
        rr = new ReadRecord(con);
        dr = new DeleteRecord(con);
    }


    CreateRecord cr;
    ReadRecord rr;
    UpdateRecord ur;
    DeleteRecord dr;

    void operate() {
        try {
            System.out.println("mustaphin marat имеет роли:" + rr.findIdRole("mustaphin marat"));

            User user = cr.createUser(new User("newName", "newLogin", "newPassword", 1));
            user = rr.readUser(user.getId());
            System.out.println(user);

            user.setName("Мустафин Марат");
            user = ur.updateUser(user);
            user = rr.readUser(user.getId());
            System.out.println(user);

            if (dr.deleteUser(user)) {
                System.out.println("Пользователь c id " + user.getId() + " удалён");
            }

            int total[] = rr.getTotal();
            System.out.println("===========================================");
            System.out.printf("\nВсего пользователей: %d", total[0]);
            System.out.printf("\nВсего ролей: %s", total[1]);
        } catch (
                SQLException e)

        {
            e.printStackTrace();
        }
    }


}
