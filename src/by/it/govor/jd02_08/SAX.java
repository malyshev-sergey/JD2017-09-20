package by.it.govor.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAX extends DefaultHandler {
    private String tab = "";
    private StringBuilder content = new StringBuilder();

    final static private String XML_PATH =
            "src/by/it/govor/jd02_07/XML.xml";

    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAX sax = new SAX();
            saxParser.parse(XML_PATH, sax);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Открытие документа");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец документа");
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + name);
        tab = tab + "\t";
        System.out.println(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String str=content.toString().trim();
        if (str.length() > 0)
            System.out.println(tab + str);
        content.setLength(0);
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(new String(ch, start, length));
    }
}
