package by.it.likhanau.jd02_07;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSchema {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName="src/by/it/likhanau/jd02_07/xsd/claim.xml";
        String schemaName="src/by/it/likhanau/jd02_07/xsd/claim.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation= new File(schemaName);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            javax.xml.validation.Validator validator=schema.newValidator();
            Source source=new StreamSource(fileName);
            validator.validate(source);
            System.out.println("Schema is valid.");
        } catch (SAXException e) {
            System.out.println("Schema is not valid.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
