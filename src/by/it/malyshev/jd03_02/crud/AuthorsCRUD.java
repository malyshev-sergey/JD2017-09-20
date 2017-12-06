package by.it.malyshev.jd03_02.crud;

import by.it.malyshev.jd03_02.ConnectionCreator;
import by.it.malyshev.jd03_02.beans.Authors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AuthorsCRUD {

    public Authors create(Authors author) throws SQLException {
        author.setId(0);

        String createAuthorsSQL = String.format(
                "insert into authors(name) values('%s');", author.getName()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (1 == statement.executeUpdate(createAuthorsSQL, RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    author.setId(id);
                }
            }
        }
        return author;
    }

    public Authors read(int id) throws SQLException {
        Authors authorResult = null;
        String readAuthorsSQL = "SELECT * FROM authors where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAuthorsSQL);
            if (resultSet.next()) {
                authorResult = new Authors(
                        resultSet.getInt("ID"),
                        resultSet.getString("name"));
            }
        }
        return authorResult;
    }

    public Authors update(Authors author) throws SQLException {
        Authors authorResult = null;
        String updateAuthorsSQL = String.format(
                "UPDATE authors SET name = '%s' WHERE authors.ID = %d",
                author.getName(), author.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            if (statement.executeUpdate(updateAuthorsSQL) == 1)
                authorResult = author;
        }
        return authorResult;
    }

    public boolean delete(Authors author) throws SQLException {
        String deleteAuthorsSQL = String.format("DELETE FROM authors WHERE authors.ID = %d", author.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteAuthorsSQL) == 1);
        }
    }

}
