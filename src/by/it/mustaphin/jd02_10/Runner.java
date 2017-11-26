package by.it.mustaphin.jd02_10;

import by.it.mustaphin.jd02_09.JAXB.JaxBToClass;
import by.it.mustaphin.jd02_09.JAXB.JaxBToXML;
import by.it.mustaphin.jd02_09.JAXB.Tickets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Runner {
    public static void main(String[] args) {
//        TaskA converter1 = new TaskA();
//        converter1.convert();

        TaskB converter2 = new TaskB();
        converter2.convert();
    }

    public static class TaskB {
        GsonBuilder builder = new GsonBuilder();
        Gson gson;

        JaxBToClass jbtc = new JaxBToClass();
        JaxBToXML jbtx = new JaxBToXML();

        public TaskB() {
            builder.serializeNulls();
            builder.setPrettyPrinting();
            gson = builder.create();
        }

        void convert() {
            jbtc.convert();
            Tickets tickets1 = jbtc.tickets;
            String json = gson.toJson(tickets1);
            System.out.println(json);
            Tickets tickets2 = gson.fromJson(json, Tickets.class);
            jbtx.convert(tickets2);
        }
    }
}
