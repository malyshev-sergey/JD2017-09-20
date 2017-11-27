package by.it.ali.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Stax {
    static void parsing() {
        String tab="";
        StringBuilder content=new StringBuilder();
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
                   content.append(reader.getText().trim());
                }
                else if (res==reader.END_ELEMENT){
                    if (content.length()>0)
                        System.out.println(tab+content.toString());
                    content.setLength(0);
                    tab=tab.replaceFirst("\t","");
                    System.out.println(tab+"<\\" + reader.getLocalName() + ">");

                    //tab = tab.substring(1);
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}