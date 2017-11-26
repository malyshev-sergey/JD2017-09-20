package by.it.shelkovich.jd2_10;

import by.it.shelkovich.jd2_10.bean.Payment;
import by.it.shelkovich.jd2_10.converter.AbstractConverter;
import by.it.shelkovich.jd2_10.converter.ConverterFactory;
import by.it.shelkovich.jd2_10.converter.Direction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Runner2_10 {
    public static void main(String[] args) {
        //TaskA_B.run();

        String path= "src/by/it/shelkovich/jd2_10/bean/data.xml";
        AbstractConverter<Payment> converter = new ConverterFactory<Payment>().getConverter(Payment.class, Direction.XML_2_JSON, path);
        converter.convert2File();
    }
}
