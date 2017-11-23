package by.it.dubrova.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class RunnerA {
    public static void main(String[] args) throws IOException {

        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String xmlFile =   "src/by/it/dubrova/jd02_07/book.xml";
        String xmlSchemaFile = "src/by/it/dubrova/jd02_07/book.xsd";

        //создание экземпляра фабрики
        SchemaFactory factory = SchemaFactory.newInstance(lang);

        File schemaLocation = new File(xmlSchemaFile);
        //создали схему
        Schema schema = null;
        try {
            schema = factory.newSchema(schemaLocation);
            //make validator
            Validator validator = schema.newValidator();
            //разбор документа
            Source source = new StreamSource(xmlFile);

            validator.validate(source);
            System.out.println("Its OK!!!");
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
