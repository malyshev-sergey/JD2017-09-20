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

public class Runner2_10 {
    public static void main(String[] args) {
        TaskA_B.run();
    }
}
