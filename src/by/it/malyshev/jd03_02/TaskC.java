package by.it.malyshev.jd03_02;

import by.it.malyshev.jd03_02.beans.*;
import by.it.malyshev.jd03_02.crud.*;
import by.it.malyshev.jd03_02.jaxbbeans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;



class TaskC {


    static void addTableData() {
        addData("src/by/it/malyshev/jd03_02/xml/Roles.xml", RolesJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Users.xml", UsersJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Books.xml", BooksJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Authors.xml", AuthorsJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Messages.xml", MessagesJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/AuthorsBooks.xml", AuthorsBooksJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Store.xml", StoreJ.class);
        addData("src/by/it/malyshev/jd03_02/xml/Orders.xml", OrdersJ.class);
    }


    private static void addData(String path, Class cls) {
        try {
            JAXBContext jc = JAXBContext.newInstance(cls);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(path);
            List<?> l;
            switch (cls.getSimpleName()) {
                case "UsersJ":
                    UsersJ usersJ = (UsersJ) u.unmarshal(reader);
                    l = usersJ.getUsersJ();
                    UsersCRUD uC=new UsersCRUD();
                    for(Object obj:l)
                        uC.create((Users) obj);
                    break;
                case "BooksJ":
                    BooksJ booksJ = (BooksJ) u.unmarshal(reader);
                    l = booksJ.getBooksJ();
                    BooksCRUD bC=new BooksCRUD();
                    for(Object obj:l)
                        bC.create((Books) obj);
                    break;
                case "AuthorsJ":
                    AuthorsJ authorsJ = (AuthorsJ) u.unmarshal(reader);
                    l = authorsJ.getAuthorsJ();
                    AuthorsCRUD aC=new AuthorsCRUD();
                    for(Object obj:l)
                        aC.create((Authors) obj);
                    break;
                case "AuthorsBooksJ":
                    AuthorsBooksJ authorsBooksJ = (AuthorsBooksJ) u.unmarshal(reader);
                    l = authorsBooksJ.getAuthorsBooksJ();
                    AuthorsBooksCRUD abC=new AuthorsBooksCRUD();
                    for(Object obj:l)
                        abC.create((AuthorsBooks) obj);
                    break;
                case "StoreJ":
                    StoreJ storeJ = (StoreJ) u.unmarshal(reader);
                    l = storeJ.getStoreJ();
                    StoreCRUD sC=new StoreCRUD();
                    for(Object obj:l)
                        sC.create((Store) obj);
                    break;
                case "MessagesJ":
                    MessagesJ messagesJ = (MessagesJ) u.unmarshal(reader);
                    l = messagesJ.getMessagesJ();
                    MessagesCRUD mC=new MessagesCRUD();
                    for(Object obj:l)
                        mC.create((Messages) obj);
                    break;
                case "OrdersJ":
                    OrdersJ ordersJ = (OrdersJ) u.unmarshal(reader);
                    l = ordersJ.getOrdersJ();
                    OrdersCRUD oC=new OrdersCRUD();
                    for(Object obj:l)
                        oC.create((Orders) obj);
                    break;
                case "RolesJ":
                    RolesJ rolesJ = (RolesJ) u.unmarshal(reader);
                    l = rolesJ.getRolesJ();
                    RolesCRUD rC=new RolesCRUD();
                    for(Object obj:l)
                        rC.create((Roles)obj);
                    break;
            }

        } catch (FileNotFoundException | JAXBException | SQLException e) {
            e.printStackTrace();
        }

    }
}

