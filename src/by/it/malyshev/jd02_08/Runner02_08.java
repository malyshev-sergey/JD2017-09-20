package by.it.malyshev.jd02_08;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Runner02_08 {

    final static private String XML_PATH =
            "src/by/it/malyshev/jd02_07/Gendata+XSD.xml";

    public static void main(String[] args) {

        System.out.println("\n\nTaskA. SAX parser\n---------------------------------------------------------\n");
        runSAX();

        System.out.println("\n\nTaskB. StAX parser\n---------------------------------------------------------\n");
        runStAX();

        System.out.println("\n\nTaskC. DOM parser\n---------------------------------------------------------\n");
        runDOM();


    }


    private static void runSAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXparser newSAX=new SAXparser();
            saxParser.parse(XML_PATH, newSAX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runStAX() {

        StAXparser newStAX = new StAXparser();
        newStAX.parse(XML_PATH);
    }


    private static void runDOM() {

        DOMparser newDOM=new DOMparser();
        newDOM.parse(XML_PATH);

    }

}
