package by.it.shishov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Сергей on 17.11.2017.
 */
public class ValidatorPersons {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename = "C:/JavaProjects/JD2017-09-20/src/by/it/shishov/jd02_07/xsd/persons.xml";
        String schemaName = "C:/JavaProjects/JD2017-09-20/src/by/it/shishov/jd02_07/xsd/Person.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println("ok");
        } catch (SAXException e) {
            System.out.println("bad");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
