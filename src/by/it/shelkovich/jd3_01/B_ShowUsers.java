package by.it.shelkovich.jd3_01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class B_ShowUsers {
    static void run(){
        ResultSet rs = DataBase.exeSelectQuery("SELECT id, username, role_id FROM users");
        try {
            while (rs.next()){
                String role = DataBase.exeSingleFieldSelectQuery("SELECT role FROM roles WHERE id = "+rs.getString("role_id"),"role");
                System.out.println(rs.getString("id")+" "+rs.getString("username")+" "+role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
