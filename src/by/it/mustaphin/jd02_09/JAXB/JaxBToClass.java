package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxBToClass {

    public Tickets tickets;
    public void convert() {
        File file = new File("src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_09" + File.separator + "JAXB" + File.separator + "Tickets.xml");
        try {
            JAXBContext jc = JAXBContext.newInstance(Tickets.class);
            Unmarshaller um = jc.createUnmarshaller();
            FileReader fr = new FileReader(file);
            System.out.println("xml прочитан");
            tickets = (Tickets) um.unmarshal(fr);
            System.out.println(tickets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
