package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Books;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksCRUD {


        public Books create(Books book) throws SQLException {
            book.setId(0);
            //формирование строки createUserSQL по данным bean user
            String createBooksSQL = String.format(
                    "insert into books(`title`,`pubyear`,`isbn`, `img`,`price`) values('%s', %d, '%s', '%s', '%s');",
                    book.getTitle(), book.getPubyear(), book.getIsbn(), book.getImg(), book.getPrice()
            );
            try (
                    //создаем соединение и объект для запросов к базе
                    Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                    Statement statement = connection.createStatement() //создаем объект для обращения к базе
            ) {
                //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
                //create(insert) update delete - это executeUpdate, а select это executeQuery
                if (1 == statement.executeUpdate(createBooksSQL, Statement.RETURN_GENERATED_KEYS)) {
                    ResultSet keys = statement.getGeneratedKeys();
                    if (keys.next()) {
                        int id = keys.getInt(1);
                        book.setId(id);
                    }
                }
            }
            return book;
        }

        public Books read(int id) throws SQLException {
            Books bookResult = null;
            String readBooksSQL = "SELECT * FROM books where ID=" + id;
            try (
                    Connection connection = ConnectionCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                final ResultSet resultSet = statement.executeQuery(readBooksSQL);
                if (resultSet.next()) {
                    bookResult = new Books(
                            resultSet.getInt("ID"),
                            resultSet.getString("title"),
                            resultSet.getInt("pubyear"),
                            resultSet.getString("isbn"),
                            resultSet.getString("img"),
                            resultSet.getDouble("price"));
                }
            }
            return bookResult;
        }

        public Books update(Books book) throws SQLException {
            Books bookResult = null;
            String updateBooksSQL = String.format(
                    "UPDATE books SET title = '%s', pubyear = %d, isbn = '%s', img = '%s',price='%s' WHERE books.ID = %d",
                    book.getTitle(), book.getPubyear(), book.getIsbn(), book.getImg(), book.getPrice(), book.getId()
            );
            try (
                    Connection connection = ConnectionCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                if (statement.executeUpdate(updateBooksSQL) == 1)
                    bookResult = book;
            }
            return bookResult;
        }

        public boolean delete(Books book) throws SQLException {
            String deleteBooksSQL = String.format("DELETE FROM books WHERE books.ID = %d", book.getId());
            try (
                    Connection connection = ConnectionCreator.getConnection();
                    Statement statement = connection.createStatement()
            ) {
                return (statement.executeUpdate(deleteBooksSQL) == 1);
            }
        }


    }
