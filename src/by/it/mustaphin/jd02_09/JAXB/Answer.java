package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Answer", propOrder = {"value"})
public class Answer {

    @XmlAttribute(required = true)
    private int answerNumber;

    @XmlValue
    private String value;

    public Answer() {}

    public int getAnswerNumber() {return answerNumber;}

    public String getValue() {return value;}

    public void setAnswerNumber(int answerNumber) {this.answerNumber = answerNumber;}

    public void setValue(String value) {this.value = value;}

    @Override
    public String toString() {return "Answer #" + answerNumber + ": " + value;}
}
