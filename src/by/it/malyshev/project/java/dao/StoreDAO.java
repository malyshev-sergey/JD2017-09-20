package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.Store;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO extends AbstractDAO implements InterfaceDAO<Store> {

    @Override
    public int create(Store store) throws SQLException {
        String createStoreSQL = String.format(
                "insert into store(quantity,books_ID) values(%d,%d);", store.getQuantity(), store.getBooks_Id()
        );
//        int id = executeCreate(createStoreSQL);
//        if (id > 0) store.setId(id);
//        return (id > 0);
        return executeCreate(createStoreSQL);
    }

    @Override
    public boolean update(Store store) throws SQLException {
        String updateStoreSQL = String.format(
                "UPDATE store SET quantity = %d,books_ID = %d WHERE store.ID = %d",
                store.getQuantity(), store.getBooks_Id(), store.getId()
        );
        return executeUpdate(updateStoreSQL);
    }

    @Override
    public boolean delete(Store store) throws SQLException {
        String deleteStoreSQL = String.format("DELETE FROM store WHERE store.ID = %d", store.getId());
        return executeUpdate(deleteStoreSQL);
    }

    @Override
    public Store read(Store store) throws SQLException {
        return getAll("where ID=" + store.getId()).get(0);
    }

    @Override
    public Store read(int id) throws SQLException {
        List<Store> store = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (store.size() > 0) {
            return store.get(0);
        } else
            return null;
    }

    @Override
    public List<Store> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Store> getAll(String WhereAndOrder) throws SQLException {
        List<Store> store = new ArrayList<>();
        String readStoreSQL = "SELECT * FROM store " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readStoreSQL);
            while (resultSet.next()) {
                Store tmpStore = new Store(
                        resultSet.getInt("ID"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("books_ID"));
                store.add(tmpStore);
            }
        }
        return store;
    }

    @Override
    public int getSize() throws SQLException {
        return executeSize("store");
    }
}
