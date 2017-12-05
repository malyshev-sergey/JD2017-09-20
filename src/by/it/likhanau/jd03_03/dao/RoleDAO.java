package by.it.likhanau.jd03_03.dao;


import by.it.likhanau.jd03_03.beans.Role;


import by.it.likhanau.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    @Override
    public boolean create(Role role) throws SQLException {
        String createUserSQL = String.format(
                "insert into roles(role) values('%s');",
                role.getIdRole()
        );
        int id = executeCreate(createUserSQL);
        if (id > 0) role.setIdRole(id);
        return (id > 0);
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String updateRoleSQL = String.format(
                "UPDATE roles SET Role = '%s' WHERE roles.ID_Role = %d",
                role.getRole(),  role.getIdRole()
        );
        return executeUpdate(updateRoleSQL);
    }

    @Override
    public boolean delete(Role user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM roles WHERE roles.ID_Role = %d", user.getIdRole());
        return executeUpdate(deleteUserSQL);
    }

    @Override
    public Role read(Role user) throws SQLException {
        return getAll("where id=" + user.getIdRole()).get(0);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String WhereAndOreder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String readRoleSQL = "SELECT * FROM roles " + WhereAndOreder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            while (resultSet.next()) {
                Role tmpRole = new Role(
                        resultSet.getString("role"));
                roles.add(tmpRole);
            }
        }
        return roles;
    }
}
