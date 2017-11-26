package by.it.shelkovich.jd2_10.converter;

import by.it.shelkovich.jd2_10.bean.Payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class Json2XmlConverter<T> extends AbstractConverter<T> {
    public Json2XmlConverter(Class clazz, Direction direction, File file) {
        super(clazz, direction, file);
    }

    @Override
    public String convert(String source) {
        try {
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            JAXBContext jc = JAXBContext.newInstance(clazz);
            StringWriter sw = new StringWriter();
            T someBean = gson.fromJson(source, clazz);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(someBean, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
