package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class RolesCRUD {

    public Roles create(Roles role) throws SQLException {
        role.setId(0);

        String createUserSQL = String.format(
                "insert into roles(role) values('%s');", role.getRole()
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
                    role.setId(id);
                }
            }
        }
        return role;
    }

    public Roles read(int id) throws SQLException {
        Roles roleResult = null;
        String readRoleSQL = "SELECT * FROM roles where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()) {
                roleResult = new Roles(
                        resultSet.getInt("ID"),
                        resultSet.getString("role"));
            }
        }
        return roleResult;
    }

    public Roles update(Roles role) throws SQLException {
        Roles roleResult = null;
        String updateRoleSQL = String.format(
                "UPDATE roles SET role = '%s' WHERE roles.ID = %d",
                role.getRole(), role.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateRoleSQL) == 1)
                roleResult = role;
        }
        return roleResult;
    }

    public boolean delete(Roles role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteRoleSQL) == 1);
        }
    }


}
