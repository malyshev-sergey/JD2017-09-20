package by.it.shelkovich.jd2_08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public abstract class XMLPrinter {
    File file;
    public XMLPrinter(String filename){
        file = new File(filename);
    }

    public abstract void print();

}
