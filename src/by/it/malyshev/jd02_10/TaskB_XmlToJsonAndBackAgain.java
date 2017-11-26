package by.it.malyshev.jd02_10;

import by.it.malyshev.jd02_09.manual.Gendata;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;


public class TaskB_XmlToJsonAndBackAgain {

    private static Gendata gendata;
    private static String json;

    public static void main(String[] args) {

        XmlUnmarshal();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        ObjectToJson(gson);
        JsonToObject(gson);
        XmlMarshal();

    }

    private static void XmlUnmarshal() {
        try {
            JAXBContext jc = JAXBContext.newInstance(Gendata.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/malyshev/jd02_09/Gendata.xml");
            gendata = (Gendata) u.unmarshal(reader);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void XmlMarshal() {

        try {
            Writer writer = new FileWriter("src/by/it/malyshev/jd02_10/Gendata_taskB.xml");
            JAXBContext context = JAXBContext.newInstance(Gendata.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            m.marshal(gendata, writer);

            System.out.println("\n\nXML-файл создан\n");
            System.out.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            m.marshal(gendata, System.out);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void ObjectToJson(Gson gson) {
        json = gson.toJson(gendata);
        try {
            Writer writer = new FileWriter("src/by/it/malyshev/jd02_10/Gendata_taskB.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Json-файл создан");
    }

    private static void JsonToObject(Gson gson) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/by/it/malyshev/jd02_10/Gendata_taskB.json"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            json = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        gendata = gson.fromJson(json, Gendata.class);
        System.out.print("\nGendata from Json=\n" + gendata.toString());
    }

}
