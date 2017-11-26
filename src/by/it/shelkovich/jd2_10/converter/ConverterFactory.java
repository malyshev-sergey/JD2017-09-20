package by.it.shelkovich.jd2_10.converter;

import by.it.shelkovich.jd2_10.bean.Payment;

import java.io.File;

public class ConverterFactory<T> {
    public AbstractConverter<T> getConverter(Class<T> clazz, Direction dir, String path){
        File file = new File(path);
        if(dir.equals(Direction.XML_2_JSON)) return new Xml2JsonConverter<>(clazz, dir, file);
        else return new Json2XmlConverter<>(clazz, dir, file);
    }
}
