package by.it.likhanau.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlIntoHtml {
    public static void main(String[] args) {

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File("src/by/it/likhanau/jd02_09/xsd/claim.xsl")));
            StreamSource source = new StreamSource(new File("src/by/it/likhanau/jd02_09/xsd/claim.xml"));
            StreamResult result = new StreamResult(new File("src/by/it/likhanau/jd02_09/xsd/claim.html"));
            transformer.transform(source, result);
            System.out.println("Done!");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
