package by.it.likhanau.jd03_03;


import by.it.likhanau.jd03_03.beans.Role;
import by.it.likhanau.jd03_03.beans.User;
import by.it.likhanau.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    private static DAO dao;

    private static void show(String prefix) throws SQLException {
        List<User> users = dao.user.getAll();
        List<Role> roles = dao.role.getAll();
        System.out.println(prefix + "\n" + users);
        System.out.println(prefix + "\n" + roles);
    }

    public static void main(String[] args) throws SQLException {

        dao = DAO.getInstance();

        User user = new User("adm", "qwerty", 1);
        Role role = new Role("administrator");
        show("1");

        dao.user.create(user);
        dao.role.create(role);
        show("2");

        user.setLogin("NewLogin");
        role.setRole("NewRole");
        dao.user.update(user);
        dao.role.update(role);
        show("3");

        dao.user.delete(user);
        dao.role.delete(role);
        show("4");


    }
}
