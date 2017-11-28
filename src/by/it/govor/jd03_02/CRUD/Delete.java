package by.it.govor.jd03_02.CRUD;


import by.it.govor.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class Delete {
 public static boolean delete(User user) throws SQLException {
  String deleteUserSQL = String.format("DELETE FROM user WHERE user.ID = %d", user.getID());
  try (
          Connection connection = ConnectionCreator.getConnection();
          Statement statement = connection.createStatement()
  ) {
   return (statement.executeUpdate(deleteUserSQL) == 1);
  }
 }
}
