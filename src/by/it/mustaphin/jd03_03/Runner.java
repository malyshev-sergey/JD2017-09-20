package by.it.mustaphin.jd03_03;

import by.it.mustaphin.jd03_03.bean.*;
import by.it.mustaphin.jd03_03.dao.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Runner {

    public static void main(String[] args) {
        DAO dao = DAO.getDAO();
        try {
            for (User user : dao.user.getAll()) {
                System.out.println(user);
            }
            for (Role role : dao.role.getAll()) {
                System.out.println(role);
            }
            for (Question question : dao.question.getAll()) {
                System.out.println(question);
            }
            for (Right right : dao.right.getAll()) {
                System.out.println(right);
            }
            for (Answer answer : dao.answer.getAll()) {
                System.out.println(answer);
            }
            System.out.println("============================================================================");
            User user = new User("Новый пользователь", "Новый логин", "Новый пароль", 1);
            if (dao.user.create(user)) {
                System.out.println(dao.user.read(user));
            }
            System.out.println("============================================================================");
            Map<String, Boolean> rights = new HashMap<>();
            rights.put("admin", false);
            rights.put("user", false);
            rights.put("guest", false);
            Right right = new Right(2, rights);
            if(dao.right.update(right)){
                System.out.println(dao.right.read(right));
            }
            System.out.println("============================================================================");
            if(dao.answer.delete(4)){
                for (Answer answer : dao.answer.getAll()) {
                    System.out.println(answer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
