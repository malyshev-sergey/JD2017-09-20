package by.it.likhanau.jd02_08;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Handler extends DefaultHandler {

    private int id;
    private String title;


    @Override
    public void startDocument()throws SAXException {
        System.out.println("Start parsing...");
    }

    @Override
    public void endDocument()throws SAXException{
        System.out.println("End parsing...");
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        String element = qName;
        String id = attributes.getValue(0);
        System.out.println("<" + element + " " + "id = " + id +  ">");
    }

    @Override
    public void endElement(String nameSpace, String localName, String qName)throws SAXException{
        String element = qName;
        System.out.println("<" + element + "/>");
    }

    @Override
    public void characters(char[] ch, int start, int end)throws SAXException{
        String str = new String(ch, start, end);
        System.out.println("\"" + str + "\"");
    }



}
