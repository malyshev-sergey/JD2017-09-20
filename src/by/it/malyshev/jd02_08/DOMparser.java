package by.it.malyshev.jd02_08;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class DOMparser {

    void printDom(String tab, Node node) {
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









