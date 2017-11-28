package by.it.ali.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Stax {
    static void parsing() {
        StringBuilder tab= new StringBuilder();
        StringBuilder content=new StringBuilder();
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("src/by/it/ali/jd02_07/persons.xml"));
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == reader.START_ELEMENT) {
                    System.out.println(tab+"<" + reader.getLocalName() + ">");
                    tab.append("\t");
                }
                else if (res==reader.CHARACTERS){
                   content.append(reader.getText().trim());
                }
                else if (res==reader.END_ELEMENT){
                    if (content.length()>0)
                        System.out.println(tab+content.toString());
                    content.setLength(0);
                    tab = new StringBuilder(tab.toString().replaceFirst("\t", ""));
                    System.out.println(tab+"<\\" + reader.getLocalName() + ">");

                    //tab = tab.substring(1);
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}