package by.it.mustaphin.jd03_01;

import java.sql.Connection;

public class Runner {
    public static void main(String[] args) {
        Connection con = new CreateConnection().connection;
        new A_AddUser(con).addUser();
        new A_AddData(con).updateCurrentPosition(2,1);
        new A_AddData(con).updateCurrentPosition(2,2);
        new A_AddData(con).updateCurrentPosition(2,3);
    }
}
