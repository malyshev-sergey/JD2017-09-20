package by.it.malyshev.project.java.dao.dto;

import by.it.malyshev.project.java.beans.AuthorsBooks;
import by.it.malyshev.project.java.dao.DAO;
import by.it.malyshev.project.java.beans.pojo.AuthorBookDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssemblerAuthorBookDTO implements InterfaceDTO<AuthorBookDTO> {

    @Override
    public List<AuthorBookDTO> getAll(String whereAndOrder) throws SQLException {

        List<AuthorBookDTO> authorBookDTOs = new ArrayList<>();
        DAO dao = DAO.getInstance();

        List<AuthorsBooks> abs = dao.authorBook.getAll(whereAndOrder);

        for (AuthorsBooks ab : abs) {

            AuthorBookDTO tmpAuthorBookDTO = new AuthorBookDTO(
                    ab.getId(),
                    ab.getAuthors_Id(),
                    ab.getBooks_Id(),
                    ab.getPosition(),
                    dao.author.read(ab.getAuthors_Id()).getAuthorname()
            );
            authorBookDTOs.add(tmpAuthorBookDTO);
        }
        return authorBookDTOs;
    }
}


