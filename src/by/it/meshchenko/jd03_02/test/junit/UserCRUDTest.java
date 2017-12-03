package by.it.meshchenko.jd03_02.test.junit;

import by.it.meshchenko.jd03_02.beans.User;
import by.it.meshchenko.jd03_02.crud.UserCRUD;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class UserCRUDTest {

    @DataPoints
    public static UserCRUD itemCRUD = new UserCRUD();
    @DataPoints
    public static User item = new User(0, "testAdmin", "super",
                null, "test11@sup.su", false,1);


    User create() throws Exception {
        User temp = itemCRUD.create(item);
        item.setId(temp.getId());
        return temp;
    }

    User read() throws Exception {
        User temp = itemCRUD.read(UserCRUDTest.item.getId());
        item.setId(temp.getId());
        return temp;
    }

    User update() throws Exception {
        item.setName("testAdmin#1");
        User temp = itemCRUD.update(item);
        item.setId(temp.getId());
        return temp;
    }

    boolean delete() throws Exception {
        return itemCRUD.delete(item);
    }

    @Test
    public void testOrder1() throws Exception {

        assertEquals(true, item.equals(create()));

        assertEquals(true, item.equals(read()));

        assertEquals(true, item.equals(update()));

        assertEquals(true, delete());
    }

}
