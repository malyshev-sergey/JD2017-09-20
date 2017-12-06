package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Messages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class MessagesCRUD {

    public Messages create(Messages message) throws SQLException {
        message.setId(0);

        String createMessagesSQL = String.format(
                "insert into messages(message,users_ID,books_ID) values('%s',%d,%d);",
                message.getMessage(), message.getUsers_Id(), message.getBooks_Id()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createMessagesSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    message.setId(id);
                }
            }
        }
        return message;
    }

    public Messages read(int id) throws SQLException {
        Messages messageResult = null;
        String readMessagesSQL = "SELECT * FROM messages where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readMessagesSQL);
            if (resultSet.next()) {
                messageResult = new Messages(
                        resultSet.getInt("ID"),
                        resultSet.getString("message"),
                        resultSet.getInt("users_ID"),
                        resultSet.getInt("books_ID"));
            }
        }
        return messageResult;
    }

    public Messages update(Messages message) throws SQLException {

        Messages messageResult = null;
        String updateMessagesSQL = String.format(
                "UPDATE messages SET message = '%s',users_ID = %d,books_ID = %d WHERE messages.ID = %d",
                message.getMessage(), message.getUsers_Id(),message.getBooks_Id(), message.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateMessagesSQL) == 1)
                messageResult = message;
        }
        return messageResult;
    }

    public boolean delete(Messages message) throws SQLException {
        String deleteMessagesSQL = String.format("DELETE FROM messages WHERE messages.ID = %d", message.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteMessagesSQL) == 1);
        }
    }

}
