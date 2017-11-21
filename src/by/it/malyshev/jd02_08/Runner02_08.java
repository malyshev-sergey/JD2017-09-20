package by.it.malyshev.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(XML_PATH);
            Element el = doc.getDocumentElement();

            System.out.println("startDocument");
            DOMparser newDOM = new DOMparser();
            newDOM.printDom("", el);
            System.out.println("endDocument");
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }

    }

}
