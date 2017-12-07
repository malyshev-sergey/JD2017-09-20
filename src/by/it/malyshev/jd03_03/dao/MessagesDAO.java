package by.it.malyshev.jd03_03.dao;

import by.it.malyshev.jd03_03.beans.Messages;
import by.it.malyshev.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessagesDAO extends AbstractDAO implements InterfaceDAO<Messages> {

    @Override
    public boolean create(Messages message) throws SQLException {
        String createMessageSQL = String.format(
                "insert into messages(message,users_ID,books_ID) values('%s',%d,%d);",
                message.getMessage(), message.getUsers_Id(), message.getBooks_Id()
        );
        int id = executeCreate(createMessageSQL);
        if (id > 0) message.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Messages message) throws SQLException {
        String updateMessageSQL = String.format(
                "UPDATE messages SET message = '%s',users_ID = %d,books_ID = %d WHERE messages.ID = %d",
                message.getMessage(), message.getUsers_Id(),message.getBooks_Id(), message.getId()
        );
        return executeUpdate(updateMessageSQL);
    }

    @Override
    public boolean delete(Messages message) throws SQLException {
        String deleteMessageSQL = String.format("DELETE FROM messages WHERE messages.ID = %d", message.getId());
        return executeUpdate(deleteMessageSQL);
    }

    @Override
    public Messages read(Messages message) throws SQLException {
        return getAll("where ID=" + message.getId()).get(0);
    }


    @Override
    public Messages read(int id) throws SQLException {
        List<Messages> message = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (message.size() > 0) {
            return message.get(0);
        } else
            return null;
    }
    @Override
    public List<Messages> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Messages> getAll(String WhereAndOrder) throws SQLException {
        List<Messages> messages = new ArrayList<>();
        String readMessageSQL = "SELECT * FROM messages " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readMessageSQL);
            while (resultSet.next()) {
                Messages tmpMessage = new Messages(
                        resultSet.getInt("ID"),
                        resultSet.getString("message"),
                        resultSet.getInt("users_ID"),
                        resultSet.getInt("books_ID"));
                messages.add(tmpMessage);
            }
        }
        return messages;
    }
}
