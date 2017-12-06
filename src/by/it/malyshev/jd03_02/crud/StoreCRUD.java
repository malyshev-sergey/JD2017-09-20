package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Store;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class StoreCRUD {

    public Store create(Store store) throws SQLException {
        store.setId(0);

        String createStoreSQL = String.format(
                "insert into store(quantity,books_ID) values(%d,%d);", store.getQuantity(), store.getBooks_Id()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createStoreSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    store.setId(id);
                }
            }
        }
        return store;
    }

    public Store read(int id) throws SQLException {
        Store storeResult = null;
        String readStoreSQL = "SELECT * FROM store where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readStoreSQL);
            if (resultSet.next()) {
                storeResult = new Store(
                        resultSet.getInt("ID"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("books_ID"));
            }
        }
        return storeResult;
    }

    public Store update(Store store) throws SQLException {

        Store storeResult = null;
        String updateStoreSQL = String.format(
                "UPDATE store SET quantity = %d,books_ID = %d WHERE store.ID = %d",
                store.getQuantity(), store.getBooks_Id(), store.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateStoreSQL) == 1)
                storeResult = store;
        }
        return storeResult;
    }

    public boolean delete(Store store) throws SQLException {
        String deleteStoreSQL = String.format("DELETE FROM store WHERE store.ID = %d", store.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteStoreSQL) == 1);
        }
    }

}
