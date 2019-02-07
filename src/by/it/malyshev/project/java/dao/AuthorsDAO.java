package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.Authors;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO extends AbstractDAO implements InterfaceDAO<Authors> {

    @Override
    public int create(Authors author) throws SQLException {
        String createAuthorSQL = String.format(
                "insert into authors(authorname) values('%s');", author.getAuthorname()
        );
//        int id = executeCreate(createAuthorSQL);
//        if (id > 0) author.setId(id);
//        return (id > 0);
        return executeCreate(createAuthorSQL);
    }

    @Override
    public boolean update(Authors author) throws SQLException {
        String updateAuthorSQL = String.format(
                "UPDATE authors SET authorname = '%s' WHERE authors.ID = %d",
                author.getAuthorname(), author.getId()
        );
        return executeUpdate(updateAuthorSQL);
    }

    @Override
    public boolean delete(Authors author) throws SQLException {
        String deleteAuthorSQL = String.format("DELETE FROM authors WHERE authors.ID = %d", author.getId());
        return executeUpdate(deleteAuthorSQL);
    }

    @Override
    public Authors read(Authors author) throws SQLException {
        return getAll("where ID=" + author.getId()).get(0);
    }

    @Override
    public Authors read(int id) throws SQLException {
        List<Authors> author = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (author.size() > 0) {
            return author.get(0);
        } else
            return null;
    }

    @Override
    public List<Authors> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Authors> getAll(String WhereAndOrder) throws SQLException {
        List<Authors> authors = new ArrayList<>();
        String readAuthorSQL = "SELECT * FROM authors " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAuthorSQL);
            while (resultSet.next()) {
                Authors tmpAuthor = new Authors(
                        resultSet.getInt("ID"),
                        resultSet.getString("authorname"));
                authors.add(tmpAuthor);
            }
        }
        return authors;
    }

    @Override
    public int getSize() throws SQLException {
        return executeSize("authors");
    }
}
