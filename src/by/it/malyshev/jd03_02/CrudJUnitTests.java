package by.it.malyshev.jd03_02;

import by.it.malyshev.jd03_02.beans.*;
import by.it.malyshev.jd03_02.crud.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrudJUnitTests {

    @BeforeClass
    public static void db() {
        DbInit.main(null);
    }


    @Test
    public void testRoles() throws Exception {

        Roles role = new Roles(0, "tester");
        RolesCRUD roleCRUD = new RolesCRUD();

        Roles res = roleCRUD.create(role);
        role.setId(res.getId());
        assertEquals(true, role.equals(roleCRUD.read(res.getId())));

        role.setRole("tester2");
        res=roleCRUD.update(role);
        assertEquals(true, role.equals(roleCRUD.read(res.getId())));

        assertEquals(true, roleCRUD.delete(res));
    }


    @Test
    public void testUsers() throws Exception {

        Users user = new Users(0, "login", "pass", "email", 2);
        UsersCRUD userCRUD = new UsersCRUD();

        Users res = userCRUD.create(user);
        user.setId(res.getId());
        assertEquals(true, user.equals(userCRUD.read(res.getId())));

        user.setLogin("loginUpdate");
        res=userCRUD.update(user);
        assertEquals(true, user.equals(userCRUD.read(res.getId())));

        assertEquals(true, userCRUD.delete(res));
    }

    @Test
    public void testAuthors() throws Exception {

        Authors author = new Authors(0, "Г Гарсиа Маркес");
        AuthorsCRUD authorCRUD = new AuthorsCRUD();

        Authors res = authorCRUD.create(author);
        author.setId(res.getId());
        assertEquals(true, author.equals(authorCRUD.read(res.getId())));

        author.setName("Габриэль Гарсиа Маркес");
        res=authorCRUD.update(author);
        assertEquals(true, author.equals(authorCRUD.read(res.getId())));

        assertEquals(true, authorCRUD.delete(res));
    }

    @Test
    public void testBooks() throws Exception {

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        BooksCRUD bookCRUD = new BooksCRUD();

        Books res = bookCRUD.create(book);
        book.setId(res.getId());
        assertEquals(true, book.equals(bookCRUD.read(res.getId())));

        book.setTitle("100 лет одиночества");
        res=bookCRUD.update(book);
        assertEquals(true, book.equals(bookCRUD.read(res.getId())));

        assertEquals(true, bookCRUD.delete(res));
    }

    @Test
    public void testMessages() throws Exception {

        Messages message = new Messages(0, "Некоторые мысли очень даже ничего.... А в целом " +
                "мне показалось, что главный герой не вписывается в эти слишком умные тексты", 1, 2);
        MessagesCRUD messageCRUD = new MessagesCRUD();

        Messages res = messageCRUD.create(message);
        message.setId(res.getId());
        assertEquals(true, message.equals(messageCRUD.read(res.getId())));

        message.setMessage("Некоторые мысли очень даже ничего.... ");
        res=messageCRUD.update(message);
        assertEquals(true, message.equals(messageCRUD.read(res.getId())));
        assertEquals(true, messageCRUD.delete(res));
    }

    @Test
    public void testOrders() throws Exception {

        Orders order = new Orders(0, 2,1,1);
        OrdersCRUD orderCRUD = new OrdersCRUD();

        Orders res = orderCRUD.create(order);
        order.setId(res.getId());
        assertEquals(true, order.equals(orderCRUD.read(res.getId())));

        order.setQuantity(3);
        res=orderCRUD.update(order);
        assertEquals(true, order.equals(orderCRUD.read(res.getId())));
        assertEquals(true, orderCRUD.delete(res));
    }

    @Test
    public void testAuthorsBooks() throws Exception {

        Authors author = new Authors(0, "Г Гарсиа Маркес");
        AuthorsCRUD authorCRUD = new AuthorsCRUD();
        Authors resA = authorCRUD.create(author);

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        BooksCRUD bookCRUD = new BooksCRUD();
        Books resB = bookCRUD.create(book);        ;

        AuthorsBooks authorBook = new AuthorsBooks(0, 1,resB.getId());
        AuthorsBooksCRUD authorBookCRUD = new AuthorsBooksCRUD();
        AuthorsBooks resAB = authorBookCRUD.create(authorBook);

        authorBook.setId(resAB.getId());
        assertEquals(true, authorBook.equals(authorBookCRUD.read(resAB.getId())));

        authorBook.setAuthors_Id(resA.getId());
        resAB=authorBookCRUD.update(authorBook);
        assertEquals(true, authorBook.equals(authorBookCRUD.read(resAB.getId())));

        assertEquals(true, authorBookCRUD.delete(resAB));

        authorCRUD.delete(resA);
        bookCRUD.delete(resB);
    }

    @Test
    public void testStore() throws Exception {

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        BooksCRUD bookCRUD = new BooksCRUD();
        Books resB = bookCRUD.create(book);        ;

        Store store = new Store(35,resB.getId());
        StoreCRUD storeCRUD = new StoreCRUD();
        Store res = storeCRUD.create(store);

        store.setId(res.getId());
        assertEquals(true, store.equals(storeCRUD.read(res.getId())));

        store.setQuantity(135);
        res=storeCRUD.update(store);
        assertEquals(true, store.equals(storeCRUD.read(res.getId())));

        assertEquals(true, storeCRUD.delete(res));

        bookCRUD.delete(resB);
    }

    @AfterClass
    public static void dbDel() {
        DbReset.main(null);
    }



}
