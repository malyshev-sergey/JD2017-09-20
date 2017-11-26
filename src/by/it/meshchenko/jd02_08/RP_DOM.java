package by.it.meshchenko.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class RP_DOM {

    private static String tab = "";

    public static void parse(String path) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            Element elem = doc.getDocumentElement();
            printDom("", elem);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        String name = node.getNodeName();
        String text = node.getNodeValue();
        if(name.compareTo("#text") != 0) {
            System.out.print(tab + "<" + prefix + name);
            NamedNodeMap atts = node.getAttributes();
            if (atts != null && atts.getLength() > 0) {
                for (int i = 0; i < atts.getLength(); i++) {
                    Node att = atts.item(i);
                    System.out.print(" " + prefix + att.getNodeName() + "='" + att.getNodeValue() + "'");
                }
            }
            System.out.println(">");
            tab = tab + "\t";
        }
        if (text != null && !text.trim().isEmpty()) {
            System.out.println(tab + prefix + text.trim());
        }
        NodeList children = node.getChildNodes();
        if (children != null && children.getLength() > 0) {
            for (int i = 0; i < children.getLength(); i++) {
                printDom("", children.item(i));
            }
        }
        if(name.compareTo("#text") != 0) {
            tab = tab.substring(1);
            System.out.println(tab + "</" + prefix + name + ">");
        }

    }
}
