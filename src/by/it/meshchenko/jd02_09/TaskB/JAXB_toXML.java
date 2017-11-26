package by.it.meshchenko.jd02_09.TaskB;

import by.it.meshchenko.jd02_09.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JAXB_toXML {
    public static void run(String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(ShoppingCenters.class);
            Marshaller m = context.createMarshaller();
            ShoppingCenters st = new ShoppingCenters() { // анонимный класс
                {
                    Rooms roomsZamok = new Rooms();
                    Rooms roomsTitan = new Rooms();
                    roomsZamok.add(new Room("D32", 540.2, 600, false));
                    roomsTitan.add(new Room("R16", 250.8, 500, false));
                    ShoppingCenter shC = new ShoppingCenter(
                            "Zamok",
                            new Address("BY", "Minsk", "str.Pobeditelei 65"),
                            56.3,
                            23.6,
                            roomsZamok);
                    this.add(shC);
                    shC = new ShoppingCenter(
                            "Titan",
                            new Address("BY", "Minsk", "str.Derghinskogo 104"),
                            56.1,
                            23.4,
                            roomsTitan);
                    this.add(shC);
                }
            };
            m.marshal(st, new FileOutputStream(path + "jd02_09/TaskB/JAXB_toXML.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out); // копия на консоль
        } catch (FileNotFoundException e) {System.out.println("XML-файл не может быть создан: " + e);}
        catch (JAXBException e) {        System.out.println("JAXB-контекст ошибочен " + e);        }
    }
}
