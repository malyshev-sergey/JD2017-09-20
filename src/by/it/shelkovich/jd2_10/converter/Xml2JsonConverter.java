package by.it.shelkovich.jd2_10.converter;

import by.it.shelkovich.jd2_10.bean.Payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

public class Xml2JsonConverter<T> extends AbstractConverter<T> {
    public Xml2JsonConverter(Class clazz, Direction direction, File file) {
        super(clazz, direction, file);
    }

    @Override
    public String convert(String source) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            StringReader reader = new StringReader(source);
            T someBean = (T) u.unmarshal(reader);

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(someBean);
            return json;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
