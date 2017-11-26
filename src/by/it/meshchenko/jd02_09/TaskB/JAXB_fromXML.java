package by.it.meshchenko.jd02_09.TaskB;

import by.it.meshchenko.jd02_09.ShoppingCenters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXB_fromXML {
    public static void run(String f) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ShoppingCenters.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(f);
            System.out.println("XML-файл прочитан:");
            Object o = u.unmarshal(reader);
            ShoppingCenters shoppingCenters = (ShoppingCenters)o ;
            System.out.println(shoppingCenters);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
