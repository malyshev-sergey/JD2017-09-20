package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;

@XmlRootElement
public class Tickets {

    @XmlElement(name = "header")
    private ArrayList<Header> headers = new ArrayList<Header>();

    @XmlElement(name = "ticket")
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Tickets() {
        super();
    }

    public void setHeaders(ArrayList<Header> headers) {
        this.headers = headers;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean addHeader(Header header) {
        return headers.add(header);
    }

    boolean addTicket(Ticket ticket) {
        return tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "Tickets:\n[headers=" + headers + "]\n[tickets=" + tickets + "]";
    }
}
