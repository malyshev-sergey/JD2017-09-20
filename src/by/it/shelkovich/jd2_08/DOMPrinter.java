package by.it.shelkovich.jd2_08;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class DOMPrinter extends XMLPrinter {

    public DOMPrinter(String filename) {
        super(filename);
    }

    @Override
    public void print() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Node node = document.getDocumentElement();
            printDOM(node);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printDOM(Node node) {
        printDOM("", node);
    }

    private void printDOM(String tab, Node node) {
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
                    printDOM(tab + "\t", children.item(i));
                }
            }
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
    }
}
