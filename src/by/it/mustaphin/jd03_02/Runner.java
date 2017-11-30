package by.it.mustaphin.jd03_02;

import by.it.mustaphin.jd03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {

        Connection con = null;
        try {
            con = CreateConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CRUDCommon cc = new CRUDCommon(con);
        cc.operate();
    }
}
