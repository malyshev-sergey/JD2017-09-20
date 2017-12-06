package by.it.malyshev.jd03_02;

import by.it.malyshev.jd03_02.beans.Users;
import by.it.malyshev.jd03_02.crud.UsersCRUD;

import java.sql.SQLException;

public class TaskA_UserTest {

    public static void main(String[] args) {

        Users user = new Users(0, "login", "pass", "email", 2);

        try {
            //проверка CRUD для пользователей
            UsersCRUD userCRUD = new UsersCRUD();

            //создание
            user=userCRUD.create(user);
            System.out.println("create: "+user+"\n");

            //чтение
            System.out.println("read: "+userCRUD.read(user.getId())+"\n");

            //обновление
            user.setLogin("loginUpdate");
            user=userCRUD.update(user);

            System.out.println("update: "+userCRUD.read(user.getId())+"\n");
            //удаление
            if (userCRUD.delete(user))
                System.out.println("delete: "+user.getId()+"\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
