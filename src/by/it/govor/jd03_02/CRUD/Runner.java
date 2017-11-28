package by.it.govor.jd03_02.CRUD;


import by.it.akhmelev.jd03_02.demo.beans.*;
import by.it.akhmelev.jd03_02.demo.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {


    by.it.govor.jd03_02.CRUD.User user = new by.it.govor.jd03_02.CRUD.User(1,"NAme5684", "Nagibator2", 53325, 2);
        try {
        UserCRUD userCRUD = new UserCRUD();


        user=Add.add(user);
        System.out.println("Add: "+user);


        System.out.println("Read: "+Read.read(user.getID()));


        user.setName("Name 53535-2");
        user=Update.update(user);


        System.out.println("Update: "+Read.read(user.getID()));


        if (Delete.delete(user))
            System.out.println("Delete ID:"+user.getID());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
