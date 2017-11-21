package by.it.govor.jd02_08;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashSet;

public class DOM {
    static boolean winFlag= true;
    public static void main(String[] args) {

        String fileName = "src/by/it/govor/JD02_07/XML.xml";

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(fileName);
            Element el=doc.getDocumentElement();
            printDom("", el,true);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }


    private static void printDom(String prefix, Node node, boolean flag) {
        String text=node.getNodeValue();

        if (text!=null) {
            if(winFlag) {
                if (flag) {
                    System.out.print("<" + prefix + ">" + text.trim());
                } else {
                    System.out.print("</" + prefix + ">" + text.trim());
                }
                if (!text.trim().equals("")) {
                    System.out.print("</" + prefix + ">");
                    winFlag = false;
                }
                System.out.println();
            }else{winFlag=true;}
        }
        NodeList children = node.getChildNodes();
        HashSet<String> seter= new HashSet<>();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(node.getNodeName() , children.item(i),seter.add(node.getNodeName()));

        }
    }
}

