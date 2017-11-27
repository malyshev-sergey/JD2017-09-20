package by.it.ali.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL {
    private final static String root="src/by/it/ali/jd02_09/";
    static void SolveTaskA(){
//        File b = new File("Persons.xml");
//        StreamSource stSrc= new StreamSource(b);
//        try{
//            Transformer t = TransformerFactory.newInstance().newTransformer(stSrc);
//            t.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(System.out));
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        } {}
            //использование XPath в преобразованиях XSL
            String fileName=root+"persons.xml";
            String fileHTML=root+"xpath.html";
            try {
                TransformerFactory tf = TransformerFactory.newInstance();
                // установка используемого XSL-преобразования
                Transformer transformer = tf.newTransformer(new StreamSource(root+"xpath.xsl"));
                // установка исходного XML-документа и конечного XML-файла
                transformer.transform(new StreamSource(fileName),
                        new StreamResult(fileHTML));
                System.out.println("Transform " + fileName + " complete");
            } catch(TransformerException e) {
                System.err.println("Impossible transform file " + fileName + " : " + e);
            }

}
}
