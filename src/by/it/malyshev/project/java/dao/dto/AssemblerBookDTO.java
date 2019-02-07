package by.it.malyshev.project.java.dao.dto;

import by.it.malyshev.project.java.beans.AuthorsBooks;
import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.beans.Store;
import by.it.malyshev.project.java.dao.DAO;
import by.it.malyshev.project.java.beans.pojo.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssemblerBookDTO implements InterfaceDTO<BookDTO> {

    @Override
    public List<BookDTO> getAll(String whereAndOrder) throws SQLException {

        List<BookDTO> bookDTOs = new ArrayList<>();
        DAO dao = DAO.getInstance();

        List<Books> books = dao.book.getAll(whereAndOrder);

        for (Books book : books) {

            List<AuthorsBooks> authorsBooks = dao.authorBook.getAll(String.format("WHERE books_ID=%d ORDER BY position", book.getId()));
            List<String> authors = new ArrayList<>();
            for (AuthorsBooks authorsBook : authorsBooks) {
                authors.add(dao.author.read(authorsBook.getAuthors_Id()).getAuthorname());
            }

            List<Store> stores = dao.store.getAll(String.format("WHERE books_ID=%d", book.getId()));
            Store store=new Store();
            if (stores.size()==1) {
                store = stores.get(0);
            }

            BookDTO tmpBookDTO = new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getPubyear(),
                    book.getIsbn(),
                    book.getPrice(),
                    authors,
                    store.getQuantity()
            );
             bookDTOs.add(tmpBookDTO);
        }
        return bookDTOs;
    }
}
