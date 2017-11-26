package by.it.shelkovich.jd2_10;

import by.it.shelkovich.jd2_10.bean.Payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskA_B {
    static void run(){
        try {

            JAXBContext jc = JAXBContext.newInstance(Payment.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/shelkovich/jd2_10/bean/data.xml");
            System.out.println("XML-файл прочитан:");
            Payment payment = (Payment) u.unmarshal(reader);
            System.out.println(payment);

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json=gson.toJson(payment);
            System.out.println("json получен:");
            System.out.println("json:\n"+json);

            System.out.println("Person из json получен:");
            Payment payment1=gson.fromJson(json,Payment.class);
            System.out.println(payment1);

            System.out.println("XML из Persons:");
            Marshaller m=jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(payment1,System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
