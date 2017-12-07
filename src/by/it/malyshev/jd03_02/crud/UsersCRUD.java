package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UsersCRUD {

    public Users create(Users user) throws SQLException {
        user.setId(0);
        //формирование строки createUserSQL по данным bean user
        String createUserSQL = String.format(
                "insert into users(login,password,email,roles_ID) values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createUserSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                }
            }
        }
        return user;
    }

    public Users read(int id) throws SQLException {
        Users userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new Users(
                        resultSet.getInt("ID"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_ID"));
            }
        }
        return userResult;
    }

    public Users update(Users user) throws SQLException {
        Users userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET login = '%s', password = '%s', email = '%s', roles_Id=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id(), user.getId()
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

    public boolean delete(Users user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        }
    }

}
