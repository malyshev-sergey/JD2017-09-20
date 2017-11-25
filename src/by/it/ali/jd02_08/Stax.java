package by.it.ali.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Stax {
    static void parsing() {
        String tab="";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("src/by/it/ali/jd02_07/persons.xml"));
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == reader.START_ELEMENT) {
                    System.out.println(tab+"<" + reader.getLocalName() + ">");
                    tab=tab+"\t";
                }
                else if (res==reader.CHARACTERS){
                    System.out.print(reader.getText().trim());
                }
                else if (res==reader.END_ELEMENT){
                    System.out.print("<\\" + reader.getLocalName() + ">"+"\n");
                    tab=tab.replaceFirst("\t","");
                    //tab = tab.substring(1);
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
