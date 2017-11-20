package by.it.shelkovich.jd2_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;

public class MySAXHandler extends DefaultHandler {
    StringBuilder tagBody;
    StringBuilder tag;
    int level = 0;
    boolean needReturnCh = true;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagBody = new StringBuilder();
        tag = new StringBuilder();
        String init = (needReturnCh?"\n":"");
        StringBuilder tab = new StringBuilder(init);

        tag.append("<").append(qName).append(" ");
        for (int i = 0; i < attributes.getLength(); i++) {
            tag.append(attributes.getLocalName(i)).append("=\"").append(attributes.getValue(i)).append("\" ");
        }
        tag.deleteCharAt(tag.length()-1).append(">");
        for (int i = 0; i < level ; i++) {
            tab.append("\t");
        }
        tab.append(tag);
        System.out.print(tab);
        level++;
        needReturnCh = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        level--;
        tag = new StringBuilder();
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < level ; i++) {
            tab.append("\t");
        }
        tag.append("</").append(qName).append(">");
        if(tagBody.length()>0){
            System.out.println(tagBody.append(tag));
            tagBody.delete(0, tagBody.length());
        }
        else System.out.println(tab.append(tag).toString());
        needReturnCh = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tagBody.append(new String(ch,start,length).trim());
    }
}
