package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxBToXML {
    void convert() {
        try {
            JAXBContext jc = JAXBContext.newInstance();
            Marshaller m = jc.createMarshaller();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
