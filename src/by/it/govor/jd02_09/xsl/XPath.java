package by.it.govor.jd02_09.xsl;


import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XPath {
    private final static String root="src/by/it/govor/jd02_09/xsl/";
    public static void main(String[ ] args) {
        String fileName=root+"XML.xml";
        String fileHTML=root+"Html.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"XSL.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
//    private static InputSource inputSource = new InputSource("src/by/it/govor/jd02_09/xsl/XML.xml");
//    private static javax.xml.xpath.XPath xpath = XPathFactory.newInstance().newXPath();
//
//    private static String getText(String expression) throws XPathExpressionException {
//        Node node = (Node) xpath.evaluate(expression, inputSource, XPathConstants.NODE);
//        return node.getTextContent();
//    }
//
//    public static void main(String[] args) throws XPathExpressionException {
//        String expression = "/users/user/name";
//        System.out.println(getText(expression));
//        expression = "/users/user/adres";
//        System.out.println(getText(expression));
//    }
}
