package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class OrdersCRUD {

    public Orders create(Orders order) throws SQLException {
        order.setId(0);

        String createOrdersSQL = String.format(
                "insert into orders(quantity,users_ID,books_ID) values(%d,%d,%d);",
                order.getQuantity(), order.getUsers_Id(), order.getBooks_Id()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createOrdersSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    order.setId(id);
                }
            }
        }
        return order;
    }

    public Orders read(int id) throws SQLException {
        Orders orderResult = null;
        String readOrdersSQL = "SELECT * FROM orders where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readOrdersSQL);
            if (resultSet.next()) {
                orderResult = new Orders(
                        resultSet.getInt("ID"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("users_ID"),
                        resultSet.getInt("books_ID"));
            }
        }
        return orderResult;
    }

    public Orders update(Orders order) throws SQLException {

        Orders orderResult = null;
        String updateOrdersSQL = String.format(
                "UPDATE orders SET quantity = %d,users_ID = %d,books_ID = %d WHERE orders.ID = %d",
                order.getQuantity(), order.getUsers_Id(),order.getBooks_Id(), order.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateOrdersSQL) == 1)
                orderResult = order;
        }
        return orderResult;
    }

    public boolean delete(Orders order) throws SQLException {
        String deleteOrdersSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteOrdersSQL) == 1);
        }
    }

}
