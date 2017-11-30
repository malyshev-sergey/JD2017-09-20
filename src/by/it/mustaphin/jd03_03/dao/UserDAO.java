package by.it.mustaphin.jd03_03.dao;

import by.it.mustaphin.jd03_03.bean.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {

    @Override
    public boolean create(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User entity) throws SQLException {
        return false;
    }

    @Override
    public User read(User entity) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll(String condition) throws SQLException {
        return null;
    }
}
