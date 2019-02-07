package by.it.malyshev.project.java.dao;

import by.it.malyshev.project.java.beans.AuthorsBooks;
import by.it.malyshev.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorsBooksDAO extends AbstractDAO implements InterfaceDAO<AuthorsBooks> {

    @Override
    public int create(AuthorsBooks authorBook) throws SQLException {
        String createAuthorBookSQL = String.format(
                "INSERT INTO authorsBooks(authors_ID,books_ID,position) VALUES(%d,%d,%d);",
                authorBook.getAuthors_Id(), authorBook.getBooks_Id(),authorBook.getPosition()
        );
//        int id = executeCreate(createAuthorBookSQL);
//        if (id > 0) authorBook.setId(id);
//        return (id > 0);
        return executeCreate(createAuthorBookSQL);
    }

    @Override
    public boolean update(AuthorsBooks authorBook) throws SQLException {
        String updateAuthorBookSQL = String.format(
                "UPDATE authorsBooks SET authors_ID = %d,books_ID = %d,position = %d WHERE authorsbooks.ID = %d",
                authorBook.getAuthors_Id(), authorBook.getBooks_Id(), authorBook.getPosition(), authorBook.getId()
        );
        return executeUpdate(updateAuthorBookSQL);
    }

    @Override
    public boolean delete(AuthorsBooks authorBook) throws SQLException {
        String deleteAuthorBookSQL = String.format("DELETE FROM authorsbooks WHERE authorsbooks.ID = %d", authorBook.getId());
        return executeUpdate(deleteAuthorBookSQL);
    }

    @Override
    public AuthorsBooks read(AuthorsBooks authorBook) throws SQLException {
        return getAll("where ID=" + authorBook.getId()).get(0);
    }

    @Override
    public AuthorsBooks read(int id) throws SQLException {
        List<AuthorsBooks> authorBook = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (authorBook.size() > 0) {
            return authorBook.get(0);
        } else
            return null;
    }

    @Override
    public List<AuthorsBooks> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<AuthorsBooks> getAll(String WhereAndOrder) throws SQLException {
        List<AuthorsBooks> authorsBooks = new ArrayList<>();
        String readAuthorBookSQL = "SELECT * FROM authorsbooks " + WhereAndOrder;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAuthorBookSQL);
            while (resultSet.next()) {
                AuthorsBooks tmpAuthorBook = new AuthorsBooks(
                        resultSet.getInt("ID"),
                        resultSet.getInt("authors_ID"),
                        resultSet.getInt("books_ID"),
                        resultSet.getInt("position"));
                authorsBooks.add(tmpAuthorBook);
            }
        }
        return authorsBooks;
    }

    @Override
    public int getSize() throws SQLException {
         return executeSize("authorsbooks");
    }
}


