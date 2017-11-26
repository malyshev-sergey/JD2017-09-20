package by.it.malyshev.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class DOMparser {

    void parse(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);

            System.out.println("startDocument");
            System.out.print("<?xml version=\"");
            System.out.print(doc.getXmlVersion());
            System.out.print("\" encoding=\"");
            System.out.print(doc.getXmlEncoding());
            System.out.println("\"?>");

            Element el = doc.getDocumentElement();
            printDom("", el);
            System.out.println("endDocument");

        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }

    }

    private void printDom(String tab, Node node) {

        StringBuilder sb = new StringBuilder();
        String nodeValue = node.getNodeValue();

        if (nodeValue == null) {
            sb.append(tab).append("<").append(node.getNodeName());
            if (node.getAttributes().getLength() > 0) {
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    sb.append(" ").append(node.getAttributes().item(i).getNodeName());
                    sb.append("=\"").append(node.getAttributes().item(i).getNodeValue()).append("\"");
                }
            }
            sb.append(">");
            System.out.println(sb.toString());
        } else if (!nodeValue.trim().equals("")) {
            sb.append(tab).append(nodeValue).append("\n");
            sb.append(tab.substring(1)).append("</");
            sb.append(node.getParentNode().getNodeName()).append(">");
            System.out.println(sb.toString());
        } else if (node.getNextSibling() == null) {
            sb.append(tab.substring(1)).append("</").append(node.getParentNode().getNodeName()).append(">");
            System.out.println(sb.toString());
        }

        tab += "\t";
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(tab, children.item(i));

        }
    }

}









