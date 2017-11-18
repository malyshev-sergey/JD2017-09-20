package by.it.meshchenko.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Runner02_07 {
    public static void main(String[] args) {

        // premises
        //  Задание по теме XML+DTD+XSD
        //  А.
        //  Разработка XML для своей предметной области

        //  B.
        //  Формирование DTD для своей предметной области

        //  C.
        //  Формирование схемы XSD для своей предметной области. Проверьте XML валидатором.

        // Принимаю следующую предметную область:
        // Помещения, которые здаются в аренду (помещения для торговли, первоначально
        // рассматривает в торговых центрах)
        // Таким образом:
        //  ShoppingCenter - торговый центр, где сдаётся помещение
        //      Name - название
        //      Adress - адрес
        //      Lat - координаты широты (для Google карт)
        //      Lng - координаты долготы (для Google карт)
        //  Room - помещение сдаваемое в аренду
        //      RoomName - номер помещения в ТЦ
        //      Square - площадь помещения
        //      Price - стоимость в месяц
        //      isRented - tru если помещение арендовано


        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName="src/by/it/meshchenko/jd02_07/ShoppingCenters.xml";
        String schemaName="src/by/it/meshchenko/jd02_07/ShoppingCenters.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaName);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(fileName);
            validator.validate(source);
            System.out.println("Файл '" + Paths.get(fileName).getFileName() + "' прошел вылидацию");
        } catch (SAXException e) {
            System.out.println("Bad");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
