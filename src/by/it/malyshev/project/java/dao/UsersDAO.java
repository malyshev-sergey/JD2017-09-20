package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends AbstractDAO implements InterfaceDAO<Users> {

    @Override
    public int create(Users user) throws SQLException {
        String createUserSQL = String.format(
                "insert into users(login,password,email,roles_ID) values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id()
        );
//        int id = executeCreate(createUserSQL);
//        if (id > 0) user.setId(id);
//        return (id > 0);
        return executeCreate(createUserSQL);
    }

    @Override
    public boolean update(Users user) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE users SET login = '%s', password = '%s', email = '%s', roles_Id=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id(), user.getId()
        );
        return executeUpdate(updateUserSQL);
    }

    @Override
    public boolean delete(Users user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        return executeUpdate(deleteUserSQL);
    }

    @Override
    public Users read(Users user) throws SQLException {
        return getAll("where ID=" + user.getId()).get(0);
    }

    @Override
        public Users read(int id) throws SQLException {
        List<Users> user = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (user.size() > 0) {
            return user.get(0);
        } else
            return null;
    }


    @Override
    public List<Users> getAll() throws SQLException {
        return getAll("");
    }



    @Override
    public List<Users> getAll(String WhereAndOrder) throws SQLException {
        List<Users> users = new ArrayList<>();
        String readUserSQL = "SELECT * FROM users " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            while (resultSet.next()) {
                Users tmpUser = new Users(
                        resultSet.getInt("ID"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_ID"));
                users.add(tmpUser);
            }
        }
        return users;
    }

    @Override
    public int getSize() throws SQLException {
        return executeSize("users");
    }

    public void setSalt (int userId, byte[] salt) throws SQLException {

            Connection connection = ConnectionCreator.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("UPDATE users SET salt = ? WHERE users.ID = ?");
            pStatement.setBytes(1,salt);
            pStatement.setInt(2, userId);
            pStatement.executeUpdate();

    }


    public byte[] getSalt (int userId) throws SQLException {

        Connection connection = ConnectionCreator.getConnection();
        PreparedStatement pStatement = connection.prepareStatement("SELECT salt FROM users WHERE users.ID = ?");
        pStatement.setInt(1, userId);
        try (ResultSet resultSet = pStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getBytes("salt");
            }
        }
        return null;
    }

}
