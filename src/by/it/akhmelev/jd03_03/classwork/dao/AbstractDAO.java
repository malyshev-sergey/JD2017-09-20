package by.it.akhmelev.jd03_03.classwork.dao;

import by.it.akhmelev.jd03_03.classwork.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {
    /** return id or -1 (fail)*/
    int executeCreate(String sql) throws SQLException {
        int result=-1;
        try (Connection connection=ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();){
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet keys=statement.getGeneratedKeys();
                keys.next();
                result=keys.getInt(1);
            }
        }
        return result;
    }

    boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection=ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();){
            return 1==statement.executeUpdate(sql);
        }
    }



}
