package by.it.meshchenko.jd02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TaskA {
    public static void run(String path, String f) {

        String fileNameXML = path + f;
        String fileNameHTML = path + "jd02_09/TaskA/ShoppingCenter.html";
        String fileNameXSL = path + "jd02_09/TaskA/ShoppingCenter.xsl";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(fileNameXSL));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileNameXML),
                    new StreamResult(fileNameHTML));
            transformer.transform(new StreamSource(fileNameXML),
                    new StreamResult(System.out));

            System.out.println("Transform " + fileNameXML + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileNameXML + " : " + e);
        }
    }
}
