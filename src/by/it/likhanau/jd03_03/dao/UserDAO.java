package by.it.likhanau.jd03_03.dao;


import by.it.likhanau.jd03_03.beans.User;
import by.it.likhanau.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    @Override
    public boolean create(User user) throws SQLException {
        String createUserSQL = String.format(
                "insert into users(Login,Password,Id_Role) values('%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getIdRole()
        );
        int id = executeCreate(createUserSQL);
        if (id > 0) user.setIdUser(id);
        return (id > 0);
    }

    @Override
    public boolean update(User user) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Id_Role =%d WHERE users.ID_User = %d",
                user.getLogin(), user.getPassword(), user.getIdRole(), user.getIdUser()
        );
        return executeUpdate(updateUserSQL);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID_User = %d", user.getIdUser());
        return executeUpdate(deleteUserSQL);
    }

    @Override
    public User read(User user) throws SQLException {
        return getAll("where id=" + user.getIdUser()).get(0);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String WhereAndOreder) throws SQLException {
        List<User> users = new ArrayList<>();
        String readUserSQL = "SELECT * FROM users " + WhereAndOreder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            while (resultSet.next()) {
                User tmpUser = new User(
                        resultSet.getString("login"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Id_Role"));
                users.add(tmpUser);
            }
        }
        return users;
    }
}
