package by.it.shelkovich.jd2_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXPrinter extends XMLPrinter {

    StringBuilder tagBody;
    StringBuilder tag;
    int level = 0;
    boolean needReturnCh = true;

    public StAXPrinter(String filename) {
        super(filename);
    }

    @Override
    public void print() {
        try {
            InputStream is = new FileInputStream(file);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(is);

            while(reader.hasNext()){
                int type=reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        startElement(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        endElement(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters(reader);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void startElement(XMLStreamReader reader){
        tagBody = new StringBuilder();
        tag = new StringBuilder();
        String init = (needReturnCh?"\n":"");
        StringBuilder tab = new StringBuilder(init);

        tag.append("<").append(reader.getLocalName()).append(" ");
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            tag.append(reader.getAttributeLocalName(i)).append("=\"").append(reader.getAttributeValue(i)).append("\" ");
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

    private void endElement(XMLStreamReader reader){
        level--;
        tag = new StringBuilder();
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < level ; i++) {
            tab.append("\t");
        }
        tag.append("</").append(reader.getLocalName()).append(">");
        if(tagBody.length()>0){
            System.out.println(tagBody.append(tag));
            tagBody.delete(0, tagBody.length());
        }
        else System.out.println(tab.append(tag).toString());
        needReturnCh = false;
    }

    private void characters(XMLStreamReader reader){
        tagBody.append(reader.getText().trim());
    }
}
