package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {"question", "answers"})
public class Ticket {

    @XmlAttribute(name = "ticketNumber")
    private String ticketNumber;

    @XmlAttribute(name = "desc")
    private String desc;

    @XmlAttribute(name = "image")
    private String image;

    @XmlElement(name = "question")
    private String question;

    @XmlElement(name = "answers")
    private Answers answers;

    public Answers getAnswers() {return answers;}

    public void setAnswers(Answers answers) {this.answers = answers;}

    public Ticket() {}

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public String getTicketNumber() {return ticketNumber;}

    public void setTicketNumber(String ticketNumber) {this.ticketNumber = ticketNumber;}

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    @Override
    public String toString() {return "Question: " + question + "\n" + answers;}
}
