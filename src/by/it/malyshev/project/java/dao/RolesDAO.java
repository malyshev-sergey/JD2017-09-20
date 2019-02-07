package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.Roles;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO extends AbstractDAO implements InterfaceDAO<Roles> {

    @Override
    public int create(Roles role) throws SQLException {
        String createRoleSQL = String.format(
                "insert into roles(role) values('%s');", role.getRole()
        );
//        int id = executeCreate(createRoleSQL);
//        if (id > 0) role.setId(id);
//        return (id > 0);
        return executeCreate(createRoleSQL);
    }

    @Override
    public boolean update(Roles role) throws SQLException {
        String updateRoleSQL = String.format(
                "UPDATE roles SET role = '%s' WHERE roles.ID = %d",
                role.getRole(), role.getId()
        );
        return executeUpdate(updateRoleSQL);
    }

    @Override
    public boolean delete(Roles role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        return executeUpdate(deleteRoleSQL);
    }

    @Override
    public Roles read(Roles role) throws SQLException {
        return getAll("where ID=" + role.getId()).get(0);
    }

    @Override
    public Roles read(int id) throws SQLException {
        List<Roles> role = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (role.size() > 0) {
            return role.get(0);
        } else
            return null;
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Roles> getAll(String WhereAndOrder) throws SQLException {
        List<Roles> roles = new ArrayList<>();
        String readRoleSQL = "SELECT * FROM roles " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            while (resultSet.next()) {
                Roles tmpRole = new Roles(
                        resultSet.getInt("ID"),
                        resultSet.getString("role"));
                roles.add(tmpRole);
            }
        }
        return roles;
    }

    @Override
    public int getSize() throws SQLException {
        return executeSize("roles");
    }
}