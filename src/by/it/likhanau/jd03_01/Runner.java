package by.it.likhanau.jd03_01;


import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        Connection con = new CreateConnection().connection;
        new C_Init(con).initDB();
        /**new A_AddUser(con).addUser();
        new A_AddData(con).addData();
        new B_ShowUsers(con).showUsers();
        new B_AddRoles(con).addRole();
        new C_Reset(con).initDB();*/
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
