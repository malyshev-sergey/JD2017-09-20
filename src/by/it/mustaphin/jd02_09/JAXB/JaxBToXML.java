package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxBToXML {
    void convert() {
        try {
            JAXBContext jc = JAXBContext.newInstance(Tickets.class);
            Marshaller m = jc.createMarshaller();
            Header header1 = new Header(1, "Text1");
            Header header2 = new Header(2, "Text2");
            Answers answers1 = new Answers();
            Answers answers2 = new Answers();
            answers1.add(new Answer(0, "Text0"));
            answers1.add(new Answer(1, "Text1"));
            answers1.add(new Answer(2, "Text2"));
            answers1.add(new Answer(3, "Text3"));
            answers1.add(new Answer(4, "Text4"));
            answers1.add(new Answer(5, "Text5"));
            answers1.add(new Answer(6, "Text6"));
            answers1.add(new Answer(7, "Text7"));
            answers2.add(new Answer(0, "Text0"));
            answers2.add(new Answer(1, "Text1"));
            answers2.add(new Answer(2, "Text2"));
            answers2.add(new Answer(3, "Text3"));
            answers2.add(new Answer(4, "Text4"));
            answers2.add(new Answer(5, "Text5"));
            answers2.add(new Answer(6, "Text6"));
            answers2.add(new Answer(7, "Text7"));
            Ticket ticket1 = new Ticket("01", "description1", "image1", "text question", answers1);
            Ticket ticket2 = new Ticket("02", "description2", "image2", "text question", answers2);
            Tickets tickets = new Tickets();
            tickets.setW("44");
            tickets.addHeader(header1);
            tickets.addHeader(header2);
            tickets.addTicket(ticket1);
            tickets.addTicket(ticket2);
            m.marshal(tickets, new FileOutputStream("src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_09" + File.separator + "JAXB" + File.separator + "Ticets_NEW.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void convert(Tickets tickets) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Tickets.class);
            Marshaller m = jc.createMarshaller();
            m.marshal(tickets, new FileOutputStream("src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_10" + File.separator + "Tikcets.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
