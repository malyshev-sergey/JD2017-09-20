package by.it.govor.jd03_02.CRUD;


import by.it.govor.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Read {
 public static User read(int id) throws SQLException {
  User userResult = null;
  String readUserSQL = "SELECT * FROM govor.user where ID=" + id;
  try (
          Connection connection = ConnectionCreator.getConnection();
          Statement statement = connection.createStatement()
  ) {
   final ResultSet resultSet = statement.executeQuery(readUserSQL);
   if (resultSet.next()) {
    userResult = new User(
            resultSet.getInt("ID"),
            resultSet.getString("Name"),
            resultSet.getString("Nick"),
            resultSet.getInt("Telephone"),
            resultSet.getInt("Role_ID"));
   }
  }
  return userResult;
 }
}
