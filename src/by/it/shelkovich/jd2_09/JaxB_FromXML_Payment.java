package by.it.shelkovich.jd2_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxB_FromXML_Payment {
    static void run() {
        try {

            JAXBContext jc = JAXBContext.newInstance(Payment.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/shelkovich/jd2_09/data.xml");
            System.out.println("XML-файл прочитан:");
            Payment payment = (Payment) u.unmarshal(reader);
            System.out.println(payment);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}