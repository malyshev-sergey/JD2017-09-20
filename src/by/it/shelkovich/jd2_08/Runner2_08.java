package by.it.shelkovich.jd2_08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Runner2_08 {
    public static void main(String[] args) {

        String fileName = "src/by/it/shelkovich/jd2_08/xsd/data.xml";
        XMLPrinter printer = new SAXPrinter(fileName);
        //printer.print();

        printer = new StAXPrinter(fileName);
        printer.print();



    }
}

