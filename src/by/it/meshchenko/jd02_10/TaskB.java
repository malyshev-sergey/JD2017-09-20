package by.it.meshchenko.jd02_10;

import by.it.meshchenko.jd02_09.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TaskB {
    public static void run(String root, String f){
        try {
            JAXBContext jc = JAXBContext.newInstance(ShoppingCenters.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(root + f);
            System.out.println("XML-файл прочитан:");
            Object o = u.unmarshal(reader);
            ShoppingCenters shoppingCenters = (ShoppingCenters)o ;
            System.out.println(shoppingCenters);

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            //маршаллизация
            String json = gson.toJson(shoppingCenters);
            System.out.print(json);
            //демаршаллизация
            ShoppingCenters st2 = gson.fromJson(json, ShoppingCenters.class);
            //System.out.print("\n\nst2=" + st2.toString());

            JAXBContext context = JAXBContext.newInstance(ShoppingCenters.class);
            Marshaller m = context.createMarshaller();
            m.marshal(st2, new FileOutputStream(root + "jd02_10/ShoppingCenters_Clone.xml"));
            System.out.println("Clone XML-файл создан");
            //m.marshal(st2, System.out); // копия на консоль

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }










    }
}
