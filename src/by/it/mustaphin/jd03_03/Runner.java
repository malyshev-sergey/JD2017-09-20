package by.it.mustaphin.jd03_03;

import by.it.mustaphin.jd03_03.bean.Role;
import by.it.mustaphin.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        DAO dao = DAO.getDAO();
        try {
            for(Role role:dao.role.getAll()){
                System.out.println(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
