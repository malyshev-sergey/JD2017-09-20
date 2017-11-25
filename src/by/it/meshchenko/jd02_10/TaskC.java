package by.it.meshchenko.jd02_10;

import by.it.meshchenko.jd02_09.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskC {
    public static void run(String root) {
        File file;
        ConverterFactory<ShoppingCenters> converterFactory = new ConverterFactory<>();
        AbstractConverter<ShoppingCenters> converter;
        //из XML-файла в JSON-текст
        System.out.println("\n--- из XML-файла в JSON-текст\n");
        converter = converterFactory.getConverter("xml_to_json", ShoppingCenters.class);
        file = new File(root + "jd02_10/ShoppingCenters.xml");
        converter.fromText(file);
        String json = converter.toText();
        System.out.println(json);

        //из XML-файла в JSON-файл
        System.out.println("\n--- из XML-файла в JSON-файл\n");
        file = new File(root + "jd02_10/json_data.json");
        converter.saveConverterResultToFile(file);
        System.out.println("\nok\n");

        //из JSON-файла в XML-текст
        System.out.println("\n--- из JSON-файла в XML-текст\n");
        converter = converterFactory.getConverter("json_to_xml", ShoppingCenters.class);
        file = new File(root + "jd02_10/json_data.json");
        converter.fromText(file);
        String xml = converter.toText();
        System.out.println(xml);

        //из JSON-текста в XML-текст
        System.out.println("\n--- из JSON-текста в XML-текст\n");
        converter.fromText(json); //берем из предыдущего вызова конвертера
        xml = converter.toText();
        System.out.println(xml);

    }
}

abstract class AbstractConverter<T> {
    //тут будут данные, т.е. сам bean
    T bean;

    //поле класса нужно, т.к. может быть bean = null;
    private final Class<T> beanClass;
    //можно попробовать обойти этот недостаток, но довольно сложно:
    //https://habrahabr.ru/post/66593/

    AbstractConverter(Class<T> beanClass) {
        bean = null;
        this.beanClass = beanClass;
    }


    Class<T> getBeanClass() {
        return beanClass;
    }

    //построение по данным из строки
    abstract public void fromText(String txtData);

    //запись результата в строку
    abstract public String toText();

    //построение по данным из файла
    //метод не абстрактный, т.к. одинаков для всех)
    void fromText(File file) {
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //специализированный метод (тот что здесь абстрактный)
        fromText(txtData);
    }

    //запись результата в файл
    //метод не абстрактный, т.к. одинаков для всех)
    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(endFile))) {
            bufferedWriter.write(
                    //специализированный метод (тот что здесь абстрактный)
                    toText()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ConverterFactory<T> {
    private enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    AbstractConverter<T> getConverter(String typeParser, Class<T> beanClass){
        Direction direction=Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXmlToJsonBuilder<>(beanClass);
            }
            case JSON_TO_XML:
            {
                return new ConverterJsonToXmlBuilder<>(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
    }
}

class ConverterJsonToXmlBuilder<T> extends AbstractConverter<T> {


    ConverterJsonToXmlBuilder(Class<T> beanClass) {
        super(beanClass);
    }

    //построение по данным из строки
    @Override
    public void fromText(String txtData) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(txtData, getBeanClass());
    }

    //запись результата в строку
    @Override
    public String toText() {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }
}

class ConverterXmlToJsonBuilder<T> extends AbstractConverter<T> {
    ConverterXmlToJsonBuilder(Class<T> beanClass) {
        super(beanClass);
    }

    //построение по данным из строки
    @Override
    public void fromText(String txtData) {
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
    public String toText() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(bean);
    }

}





