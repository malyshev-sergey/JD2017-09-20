package by.it.malyshev.jd03_03;

import by.it.malyshev.jd03_03.beans.*;
import by.it.malyshev.jd03_03.dao.DAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaoJUnitTests {

    private DAO dao=DAO.getInstance();

    @BeforeClass
    public static void db() {
        DbInit.main(null);
    }

    @Test
    public void testRoles() throws Exception {

        Roles role = new Roles(0, "tester");
        dao.role.create(role);
        Roles res=dao.role.read(role);
        assertEquals(role, res);

        role.setRole("tester2");
        dao.role.update(role);
        res=dao.role.read(role);
        assertEquals(role,res);

        assertEquals(true, dao.role.delete(res));
    }


    @Test
    public void testUsers() throws Exception {

        Users user = new Users(0, "login", "pass", "email", 2);
        dao.user.create(user);
        Users res = dao.user.read(user);
        assertEquals(user,res);

        user.setLogin("loginUpdate");
        dao.user.update(user);
        res=dao.user.read(user);
        assertEquals(user,res);

        assertEquals(true, dao.user.delete(res));
    }

    @Test
    public void testAuthors() throws Exception {

        Authors author = new Authors(0, "Г Гарсиа Маркес");
        dao.author.create(author);
        Authors res = dao.author.read(author);
        assertEquals(author,res);

        author.setName("Габриэль Гарсиа Маркес");
        dao.author.update(author);
        res=dao.author.read(author);
        assertEquals(author,res);

        assertEquals(true, dao.author.delete(res));
    }

    @Test
    public void testBooks() throws Exception {

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        dao.book.create(book);
        Books res = dao.book.read(book);
        assertEquals(book,res);

        book.setTitle("100 лет одиночества");
        dao.book.update(book);
        res=dao.book.read(book);
        assertEquals(book,res);

        assertEquals(true, dao.book.delete(res));
    }

    @Test
    public void testMessages() throws Exception {

        Messages message = new Messages(0, "Некоторые мысли очень даже ничего.... А в целом " +
                "мне показалось, что главный герой не вписывается в эти слишком умные тексты", 1, 2);
        dao.message.create(message);
        Messages res = dao.message.read(message);
        assertEquals(message,res);

        message.setMessage("Некоторые мысли очень даже ничего.... ");
        dao.message.update(message);
        res=dao.message.read(message);
        assertEquals(message,res);

        assertEquals(true, dao.message.delete(res));
    }

    @Test
    public void testOrders() throws Exception {

        Orders order = new Orders(0, 2,1,1);
        dao.order.create(order);
        Orders res = dao.order.read(order);
        assertEquals(order,res);

        order.setQuantity(3);
        dao.order.update(order);
        res=dao.order.read(order);
        assertEquals(order,res);

        assertEquals(true, dao.order.delete(res));

    }

    @Test
    public void testAuthorsBooks() throws Exception {

        Authors author = new Authors(0, "Г Гарсиа Маркес");
        dao.author.create(author);
        Authors resA = dao.author.read(author);

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        dao.book.create(book);
        Books resB = dao.book.read(book);

        AuthorsBooks authorBook = new AuthorsBooks(0, 1,resB.getId());
        dao.authorBook.create(authorBook);
        AuthorsBooks res = dao.authorBook.read(authorBook);
        assertEquals(authorBook,res);

        authorBook.setAuthors_Id(resA.getId());
        dao.authorBook.update(authorBook);
        res=dao.authorBook.read(authorBook);
        assertEquals(authorBook,res);

        assertEquals(true, dao.authorBook.delete(res));
        dao.author.delete(resA);
        dao.book.delete(resB);
    }

    @Test
    public void testStore() throws Exception {

        Books book = new Books(0, "Сто лет одиночества", 2012, "978-5-17-071285-4", "/img/img1.jpg", 21.41);
        dao.book.create(book);
        Books resB = dao.book.read(book);

        Store store = new Store(35,resB.getId());
        dao.store.create(store);
        Store res = dao.store.read(store);
        assertEquals(store,res);


        store.setQuantity(135);
        dao.store.update(store);
        res=dao.store.read(store);
        assertEquals(store,res);

        assertEquals(true, dao.store.delete(res));
        dao.book.delete(resB);
    }

    @AfterClass
    public static void dbDel() {
        DbReset.main(null);
    }




}
