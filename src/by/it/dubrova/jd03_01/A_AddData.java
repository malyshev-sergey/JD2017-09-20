package by.it.dubrova.jd03_01;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    public static void add(Statement statement, int user_id, String title, String description, int price, Date date){
        try {
            statement.execute("insert into ads (user_id,title,description,price,date)" +
                    "values ('"+user_id+"','"+title+"','"+description+"','"+price+"','"+date+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
