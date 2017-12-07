package by.it.meshchenko.project.java.dao;

import by.it.meshchenko.project.java.beans.Role;
import by.it.meshchenko.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements IDAO<Role> {
    
    @Override
    public Role read(int id) {
        List<Role> items = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (items.size() > 0) {
            return items.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role item) {
        String sql = String.format(
                "INSERT INTO crm_roles(" +
                        "Role)" +
                        " VALUES('%s');",
                item.getRole()
        );
        item.setId(executeCreate(sql));
        return (item.getId()>0);
    }

    @Override
    public boolean update(Role item) {
//        String sql = String.format(
//                "UPDATE crm_users SET " +
//                        "Name = '%s', Password = '%s',%s Email = '%s', " +
//                        "EmailConfirmed = %d%s WHERE Id = %d",
//                item.getName(),
//                item.getPassword(),
//                item.getPhoneNumber() == null ? "" : "PhoneNumber=\'" + item.getPhoneNumber() + "\',",
//                item.getEmail(),
//                item.isEmailConfirmed() ? 1 : 0,
//                item.getRoleId() == null ? "" : ",RoleId=" + item.getRoleId().toString(),
//                item.getId()
//        );
        //return executeUpdate(sql);
        return false;
    }

    @Override
    public boolean delete(Role item) {
//        String sql = String.format(
//                "DELETE FROM crm_users WHERE Id = %d", item.getId());
//        return executeUpdate(sql);
        return false;
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) {
        List<Role> items = new ArrayList<>();
        String sql = "SELECT * FROM crm_roles " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role item = new Role();

                item.setId(rs.getInt("Id"));
                item.setRole(rs.getString("Role"));
                items.add(item);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return items;
    }
}
