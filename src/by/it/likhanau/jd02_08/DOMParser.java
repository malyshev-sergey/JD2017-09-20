package by.it.likhanau.jd02_08;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {
    public static void main(String[] args) {
        Document xmlDoc = getDocument("src/by/it/likhanau/jd02_08/xsd/claim.xml");
        Node node = xmlDoc.getDocumentElement();
        printDOM(node);
    }


    private static Document getDocument(String docString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);


            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(docString));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void printDOM(Node node) {
            String tab = "\t";
            StringBuilder tag = new StringBuilder();
            if (node.getNodeName().equals("#text")) {
                if (node.getNodeValue().trim().length() > 0) System.out.println(tab + node.getNodeValue().trim());
            } else {
                tag.append("<").append(node.getNodeName());

                if (node.hasAttributes()) {
                    NamedNodeMap attrs = node.getAttributes();
                    for (int i = 0; i < attrs.getLength(); i++) {
                        Node attr = attrs.item(i);
                        tag.append(" ").append(attr.getNodeName()).append("=\"").append(attr.getNodeValue()).append("\"");
                    }
                }
                tag.append(">");
                System.out.println(tab + tag);

                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++) {
                        printDOM(children.item(i));
                    }
                }
                System.out.println(tab + "</" + node.getNodeName() + ">");
            }
        }

}