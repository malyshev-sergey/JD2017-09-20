package by.it.malyshev.jd03_03.jaxbbeans;

import by.it.malyshev.jd03_03.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "messagesJ"
})
@XmlRootElement(name = "messagesJ")
public class MessagesJ {

    @XmlElement(name = "messages", required = true)
    List<Messages> messagesJ=new ArrayList<>();

    public MessagesJ() {
    }

    public MessagesJ(List<Messages> messagesJ) {
        this.messagesJ = messagesJ;
    }

    public List<Messages> getMessagesJ() {
        return messagesJ;
    }

    public void setMessagesJ(List<Messages> messagesJ) {
        this.messagesJ = messagesJ;
    }
}