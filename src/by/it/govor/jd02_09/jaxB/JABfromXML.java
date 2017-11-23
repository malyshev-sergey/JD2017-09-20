package by.it.govor.jd02_09.jaxB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JABfromXML {
        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Users.class);
                Unmarshaller marh = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/govor/jd02_09/jaxB/xml1.xml");
                System.out.println("XML-файл прочитан:");
                Users users = (Users) marh.unmarshal(reader);
                System.out.println(users);

            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }