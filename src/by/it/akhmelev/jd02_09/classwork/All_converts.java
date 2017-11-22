package by.it.akhmelev.jd02_09.classwork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class All_converts {
        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Persons.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/akhmelev/jd02_09/classwork/Persons.xml");
                System.out.println("XML-файл прочитан:");
                Persons persons = (Persons) u.unmarshal(reader);
                System.out.println(persons);

                Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
                String json=gson.toJson(persons);
                System.out.println("json получен:");
                System.out.println("json:\n"+json);

                System.out.println("Person из json получен:");
                Persons persons1=gson.fromJson(json,Persons.class);
                System.out.println(persons1);

                System.out.println("XML из Persons:");
                Marshaller m=jc.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(persons1,System.out);




            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }