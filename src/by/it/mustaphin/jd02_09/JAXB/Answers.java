package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Answer.class})
@XmlType(name = "Answers", propOrder = "answers")
public class Answers {

    @XmlElement(name = "answer")
    private ArrayList<Answer> answers = new ArrayList<Answer>();

    public void add(Answer answer) {
        answers.add(answer);
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answers: [" + answers + "]";
    }
}
