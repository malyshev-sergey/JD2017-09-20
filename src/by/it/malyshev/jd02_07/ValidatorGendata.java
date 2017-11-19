package by.it.malyshev.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorGendata {

    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename= "src/by/it/malyshev/jd02_07/Gendata+XSD.xml";
        String schemaName= "src/by/it/malyshev/jd02_07/Gendata.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaName);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(filename);
            validator.validate(source);
            System.out.println(filename+" file is valid");
        } catch (SAXException e) {
            System.out.println(filename+" file is valid");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
