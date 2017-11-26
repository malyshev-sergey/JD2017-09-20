package by.it.malyshev.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TaskA_GendataXmlToHtmlTransformer {

    private final static String root="src/by/it/malyshev/jd02_09/";

    public static void main(String[ ] args) {
        String fileName=root+"Gendata.xml";
        String fileHTML=root+"Gendata.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"transformer/Gendata.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(System.out));

            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }


}
