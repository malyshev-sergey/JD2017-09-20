package by.it.akhmelev.jd03_03.classwork.dao;

import by.it.akhmelev.jd03_03.classwork.bean.Role;

public class DAO {

    private static DAO dao;

    public UniversalDAO<Role> role;
    public UserDAO user;

    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new UniversalDAO<>(new Role(), "roles");
                }
            }
        }
        return dao;
    }
}
