package by.it.akhmelev.jd03_03.classwork;

import by.it.akhmelev.jd03_03.classwork.bean.User;
import by.it.akhmelev.jd03_03.classwork.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    private static DAO dao;

    private static void show(String prefix) throws SQLException {
        List<User> users=dao.user.getAll();
        System.out.println(prefix+"\n"+users);
    }

    public static void main(String[] args) throws SQLException {

        dao=DAO.getInstance();

        User user=new User("demologin","pass","hi@it.by",2);
        show("1");

        dao.user.create(user);
        show("2");

        user.setLogin("NewLogin");
        dao.user.update(user);
        show("3");

        dao.user.delete(user);
        show("4");

        System.out.println(dao.role.getAll(""));

    }
}
