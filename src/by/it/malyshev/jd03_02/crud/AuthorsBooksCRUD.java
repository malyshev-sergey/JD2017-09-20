package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.AuthorsBooks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AuthorsBooksCRUD {

    public AuthorsBooks create(AuthorsBooks authorBook) throws SQLException {
        authorBook.setId(0);

        String createAuthorsBooksSQL = String.format(
                "insert into authorsBooks(authors_ID,books_ID) values(%d,%d);",
                authorBook.getAuthors_Id(), authorBook.getBooks_Id()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createAuthorsBooksSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    authorBook.setId(id);
                }
            }
        }
        return authorBook;
    }

    public AuthorsBooks read(int id) throws SQLException {
        AuthorsBooks authorBookResult = null;
        String readAuthorsBooksSQL = "SELECT * FROM authorsbooks where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAuthorsBooksSQL);
            if (resultSet.next()) {
                authorBookResult = new AuthorsBooks(
                        resultSet.getInt("ID"),
                       resultSet.getInt("authors_ID"),
                        resultSet.getInt("books_ID"));
            }
        }
        return authorBookResult;
    }

    public AuthorsBooks update(AuthorsBooks authorBook) throws SQLException {

        AuthorsBooks authorBookResult = null;
        String updateAuthorsBooksSQL = String.format(
                "UPDATE authorsBooks SET authors_ID = %d,books_ID = %d WHERE authorsbooks.ID = %d",
                authorBook.getAuthors_Id(), authorBook.getBooks_Id(), authorBook.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateAuthorsBooksSQL) == 1)
                authorBookResult = authorBook;
        }
        return authorBookResult;
    }

    public boolean delete(AuthorsBooks authorBook) throws SQLException {
        String deleteAuthorsBooksSQL = String.format("DELETE FROM authorsbooks WHERE authorsbooks.ID = %d", authorBook.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteAuthorsBooksSQL) == 1);
        }
    }


}
