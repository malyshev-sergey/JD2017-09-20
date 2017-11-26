package by.it.mustaphin.jd02_09.XSL;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTranslator {

    String root = "src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_09" + File.separator + "XSL" + File.separator;

    public void toDo() {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(root + "Tickets.xsl"));
            transformer.transform(new StreamSource(root + "Tickets.xml"), new StreamResult(root + "Tickets.html"));
            System.out.println("Transforming complete");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
