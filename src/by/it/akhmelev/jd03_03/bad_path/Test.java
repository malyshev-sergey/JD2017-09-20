package by.it.akhmelev.jd03_03.bad_path;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getInstance();
        List<User> users=dao.user.getAll("");
        System.out.println(users);
        List<Role> roles=dao.role.getAll("");
        System.out.println(roles);
        List<Ad> ads=dao.ad.getAll("");
        System.out.println(ads);
    }
}
