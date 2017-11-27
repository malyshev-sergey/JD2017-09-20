package by.it.ali.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    static void parser(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc;
        try{
            builder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        File f = new File("src/by/it/ali/jd02_07/persons.xml");
        try
        {
            doc=builder.parse(f);
            Element r= doc.getDocumentElement();
            System.out.println(r.getTagName());
            printer(r);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    static void printer(Node r){
        NodeList nList = r.getChildNodes();
        for (int i = 0; i < nList.getLength() ; i++) {
            if (nList.item(i) instanceof Element)
                System.out.println(nList.item(i).getNodeName());
        }
    }
}
