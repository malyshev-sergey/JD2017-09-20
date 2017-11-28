package by.it.govor.jd02_08;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAX {
    final static private String XML_PATH =
            "src/by/it/govor/jd02_07/XML.xml";
    public static void main(String[] args) {
        String empty="";
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInput = new FileInputStream(XML_PATH);) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInput);
            String tab = "";
            while (reader.hasNext()) {
                int data = reader.next();
                switch (data) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "<" + reader.getLocalName());
                        tab = tab + "\t";
                        System.out.println(">");

                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        empty=empty.concat(reader.getText().trim());
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT: {
                        if (!empty.isEmpty())
                            System.out.println(tab + empty);
                        tab = tab.substring(1);
                        empty = "";
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    }
                }
            }
            } catch(Exception e){
                System.err.println("FUCK " + e);
            }


    }
}
