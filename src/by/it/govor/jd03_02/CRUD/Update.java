package by.it.govor.jd03_02.CRUD;


import by.it.govor.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class Update {
 public static User update(User user) throws SQLException {
  User userResult = null;
  String updateUserSQL = String.format(
          "UPDATE user SET Name = '%s', Nick = '%s', Telephone = '%d',role_ID=%d WHERE user.ID = %d",
          user.getName(), user.getNick(), user.getTelephone(), user.getRole_ID(), user.getID()
  );
  try (
          Connection connection = ConnectionCreator.getConnection();
          Statement statement = connection.createStatement()
  ) {
   if (statement.executeUpdate(updateUserSQL) == 1)
    userResult = user;
  }
  return userResult;
 }
}
