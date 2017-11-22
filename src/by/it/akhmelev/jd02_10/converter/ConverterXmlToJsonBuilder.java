package by.it.akhmelev.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

class ConverterXmlToJsonBuilder<T> extends AbstractConverter<T> {
    ConverterXmlToJsonBuilder(Class<T> beanClass) {
        super(beanClass);
    }

    //построение по данным из строки
    @Override
    public void buildConverter(String txtData) {
        try {
            StringReader stringReader = new StringReader(txtData);
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Unmarshaller u = jc.createUnmarshaller();
            Object oBean=u.unmarshal(stringReader);
            //вместо такого приведения (T)oBean,
            //используем такое (чтобы подавить warnings)
            bean = getBeanClass().cast(oBean);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    //запись результата в строку
    @Override
    public String getConverterResult() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(bean);
    }

}
