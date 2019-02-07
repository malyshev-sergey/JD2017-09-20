package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.Orders;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends AbstractDAO implements InterfaceDAO<Orders> {

    @Override
    public int create(Orders order) throws SQLException {
        String createOrderSQL = String.format(
                "insert into orders(quantity,users_ID,books_ID) values(%d,%d,%d);",
                order.getQuantity(), order.getUsers_Id(), order.getBooks_Id()
        );
//        int id = executeCreate(createOrderSQL);
//        if (id > 0) order.setId(id);
//        return (id > 0);
        return executeCreate(createOrderSQL);
    }

    @Override
    public boolean update(Orders order) throws SQLException {
        String updateOrderSQL = String.format(
                "UPDATE orders SET quantity = %d,users_ID = %d,books_ID = %d WHERE orders.ID = %d",
                order.getQuantity(), order.getUsers_Id(),order.getBooks_Id(), order.getId()
        );
        return executeUpdate(updateOrderSQL);
    }

    @Override
    public boolean delete(Orders order) throws SQLException {
        String deleteOrderSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        return executeUpdate(deleteOrderSQL);
    }

    @Override
    public Orders read(Orders order) throws SQLException {
        return getAll("where ID=" + order.getId()).get(0);
    }

    @Override
    public Orders read(int id) throws SQLException {
        List<Orders> order = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (order.size() > 0) {
            return order.get(0);
        } else
            return null;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Orders> getAll(String WhereAndOrder) throws SQLException {
        List<Orders> orders = new ArrayList<>();
        String readOrderSQL = "SELECT * FROM orders " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readOrderSQL);
            while (resultSet.next()) {
                Orders tmpOrder = new Orders(
                        resultSet.getInt("ID"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("users_ID"),
                        resultSet.getInt("books_ID"));
                orders.add(tmpOrder);
            }
        }
        return orders;
    }

    @Override
    public int getSize() throws SQLException {
        return executeSize("orders");
    }
}
