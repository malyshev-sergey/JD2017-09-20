package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Answers", propOrder = "answers")
public class Answers {

    @XmlElement(name = "answer")
    private ArrayList<Answer> answers = new ArrayList<Answer>();

    public ArrayList<Answer> getAnswers() {return answers;}

    public void setAnswers(ArrayList<Answer> answers) {this.answers = answers;}

    @Override
    public String toString() {return "Answers: [" + answers + "]";}
}
