package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="tickets")
@XmlSeeAlso({Ticket.class, Header.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tickets", propOrder = {"headers", "tickets"})
public class Tickets {

    @XmlAttribute(name = "W")
    private String w;
    @XmlElement(name = "header")
    private ArrayList<Header> headers = new ArrayList<Header>();
    @XmlElement(name = "ticket")
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Tickets() {
        super();
    }

    public void setW(String w) {
        this.w = w;
    }

    public void setHeaders(ArrayList<Header> headers) {
        this.headers = headers;
    }

    public boolean addHeader(Header header) {
        return headers.add(header);
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean addTicket(Ticket ticket) {
        return tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "Header [headers=" + headers + "]\nTickets W=" + w + " [tickets=" + tickets + "]";
    }
}
