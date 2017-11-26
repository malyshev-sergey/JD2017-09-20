package by.it.dubrova.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    public static void add(Statement statement, String email, String name, String pwd, int role){
        try {
            statement.execute("insert into users (email,name,password,role) values ('"+email+"','"+name+"','"+pwd+"','"+role+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
