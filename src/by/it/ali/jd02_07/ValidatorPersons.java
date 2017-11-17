package by.it.ali.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorPersons {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename="src/by/it/ali/jd02_07/xsd/Persons.xml";
        String schemaname="src/by/it/ali/jd02_07/xsd/Person.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation= new File(schemaname);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(filename);
            validator.validate(source);
            System.out.println("OK");
        } catch (SAXException e) {
            System.out.println("BAD");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
