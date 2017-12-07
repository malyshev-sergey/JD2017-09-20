package by.it.likhanau.jd03_03.dao;


public class DAO {
    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;

    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                }
            }
        }
        return dao;
    }
}
