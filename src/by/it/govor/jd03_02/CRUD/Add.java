package by.it.govor.jd03_02.CRUD;

import by.it.govor.jd03_02.ConnectionCreator;

import java.sql.*;


import java.sql.Connection;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

class Add {
     public static  User add(User user) throws SQLException {
         String createUserSQL = String.format(
                 "insert into user(Name,Nick,Telephone,role_ID) values('%s','%s',%d,%d);",
                 user.getName(), user.getNick(), user.getTelephone(), user.getRole_ID()
         );
         try (
                 Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {

             if (1 == statement.executeUpdate(createUserSQL, RETURN_GENERATED_KEYS)) {
                 ResultSet keys = statement.getGeneratedKeys();
                 if (keys.next()) {
                     int id = keys.getInt(1);
                     user.setID(id);
                 }
             }
         }
         return user;
     }
}
