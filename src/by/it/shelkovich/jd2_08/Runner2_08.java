package by.it.shelkovich.jd2_08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Runner2_08 {
    public static void main(String[] args) {

        String fileName = "src/by/it/shelkovich/jd2_08/xsd/data.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MySAXHandler handler = new MySAXHandler();
            parser.parse(new File(fileName), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

