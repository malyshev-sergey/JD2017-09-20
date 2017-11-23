package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {""})
public class Ticket {

    @XmlElement(name = "Question")
    private String question;

    @XmlElement(name = "Answers")
    private ArrayList<Answer> answers = new ArrayList<Answer>();
}
