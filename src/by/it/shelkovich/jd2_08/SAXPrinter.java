package by.it.shelkovich.jd2_08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXPrinter extends XMLPrinter {

    public SAXPrinter(String filename) {
        super(filename);
    }

    public void print(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MySAXHandler handler = new MySAXHandler();
            parser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
