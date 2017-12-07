package by.it.malyshev.jd03_03;

import by.it.malyshev.jd03_03.beans.*;
import by.it.malyshev.jd03_03.dao.DAO;
import by.it.malyshev.jd03_03.jaxbbeans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;


class JaxBfillTables {


    static void addTableData() {
        addData("src/by/it/malyshev/jd03_03/xml/Roles.xml", RolesJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Users.xml", UsersJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Books.xml", BooksJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Authors.xml", AuthorsJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Messages.xml", MessagesJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/AuthorsBooks.xml", AuthorsBooksJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Store.xml", StoreJ.class);
        addData("src/by/it/malyshev/jd03_03/xml/Orders.xml", OrdersJ.class);
    }


    private static void addData(String path, Class cls) {
        try {
            JAXBContext jc = JAXBContext.newInstance(cls);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(path);
            DAO dao=DAO.getInstance();
            List<?> l;
            switch (cls.getSimpleName()) {
                case "UsersJ":
                    UsersJ usersJ = (UsersJ) u.unmarshal(reader);
                    l = usersJ.getUsersJ();
                    for(Object obj:l)
                        dao.user.create((Users) obj);
                    break;
                case "BooksJ":
                    BooksJ booksJ = (BooksJ) u.unmarshal(reader);
                    l = booksJ.getBooksJ();
                    for(Object obj:l)
                        dao.book.create((Books) obj);
                    break;
                case "AuthorsJ":
                    AuthorsJ authorsJ = (AuthorsJ) u.unmarshal(reader);
                    l = authorsJ.getAuthorsJ();
                    for(Object obj:l)
                        dao.author.create((Authors) obj);
                    break;
                case "AuthorsBooksJ":
                    AuthorsBooksJ authorsBooksJ = (AuthorsBooksJ) u.unmarshal(reader);
                    l = authorsBooksJ.getAuthorsBooksJ();
                    for(Object obj:l)
                        dao.authorBook.create((AuthorsBooks) obj);
                    break;
                case "StoreJ":
                    StoreJ storeJ = (StoreJ) u.unmarshal(reader);
                    l = storeJ.getStoreJ();
                    for(Object obj:l)
                        dao.store.create((Store) obj);
                    break;
                case "MessagesJ":
                    MessagesJ messagesJ = (MessagesJ) u.unmarshal(reader);
                    l = messagesJ.getMessagesJ();
                    for(Object obj:l)
                        dao.message.create((Messages) obj);
                    break;
                case "OrdersJ":
                    OrdersJ ordersJ = (OrdersJ) u.unmarshal(reader);
                    l = ordersJ.getOrdersJ();
                    for(Object obj:l)
                        dao.order.create((Orders) obj);
                    break;
                case "RolesJ":
                    RolesJ rolesJ = (RolesJ) u.unmarshal(reader);
                    l = rolesJ.getRolesJ();
                    for(Object obj:l)
                        dao.role.create((Roles) obj);
                    break;
            }

        } catch (FileNotFoundException | JAXBException | SQLException e) {
            e.printStackTrace();
        }

    }
}

