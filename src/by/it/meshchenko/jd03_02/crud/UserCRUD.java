package by.it.meshchenko.jd03_02.crud;

import by.it.meshchenko.jd03_02.*;
import by.it.meshchenko.jd03_02.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserCRUD {

    public User create(User item) throws SQLException {
        item.setId(0);
        String createItemSQL = String.format(
                "INSERT INTO crm_users(" +
                        "Name,Password,%sEmail,EmailConfirmed%s)" +
                        " VALUES('%s','%s',%s'%s',%d%s);",
                item.getPhoneNumber() == null ? "" : "PhoneNumber,",
                item.getRoleId() == null ? "" : ",RoleId",
                item.getName(), //PhoneNumber
                item.getPassword(),
                item.getPhoneNumber() == null ? "" : "\'" + item.getPhoneNumber() + "\',",
                item.getEmail(),
                item.isEmailConfirmed() ? 1 : 0,
                item.getRoleId() == null ? "" : "," + item.getRoleId()
        );
        System.out.println(createItemSQL);
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createItemSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    item.setId(id);
                }
            }
        }
        return item;
    }

    public User read(int id) throws SQLException {
        User itemResult = null;
        Object tempObj;
        String readItemSQL = "SELECT * FROM crm_users WHERE ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readItemSQL);
            if (resultSet.next()) {
                itemResult = new User(
                        resultSet.getInt("Id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Password"),
                        (tempObj = resultSet.getObject("PhoneNumber")) == null
                                ? null : tempObj.toString(),
                        resultSet.getString("Email"),
                        resultSet.getBoolean("EmailConfirmed"),
                        (tempObj = resultSet.getObject("RoleId")) == null
                                ? null : Integer.valueOf(tempObj.toString()));
            }
        }
        return itemResult;
    }

    public User update(User item) throws SQLException {
        User itemResult = null;
        //String temp = "";
        String updateItemSQL = String.format(
                "UPDATE crm_users SET " +
                        "Name = '%s', Password = '%s',%s Email = '%s', " +
                        "EmailConfirmed = %d%s WHERE Id = %d",
                item.getName(),
                item.getPassword(),
                item.getPhoneNumber() == null ? "" : "PhoneNumber=\'" + item.getPhoneNumber() + "\',",
                item.getEmail(),
                item.isEmailConfirmed() ? 1 : 0,
                item.getRoleId() == null ? "" : ",RoleId=" + item.getRoleId().toString(),
                item.getId()
        );
        System.out.println(updateItemSQL);
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateItemSQL) == 1)
                itemResult = item;
        }
        return itemResult;
    }

    public boolean delete(User item) throws SQLException {
        String deleteItemSQL = String.format("DELETE FROM crm_users WHERE Id = %d", item.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteItemSQL) == 1);
        }
    }
}
