package by.it.malyshev.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXparser extends DefaultHandler {

    private String tab = "";
    private StringBuilder content = new StringBuilder();


    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i=0; i<attributes.getLength(); i++){
            String attName=attributes.getLocalName(i);
            String attValue=attributes.getValue(i);
            System.out.print(" "+attName+"="+attValue);
        }

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
