package by.it.govor.jd02_09.jaxB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Users {
    @XmlElement(name="student")
    private ArrayList<User> list = new ArrayList<User>();
    public Users() {
        super();
    }
    public void setList(ArrayList<User> list) {
        this.list = list;
    }
    public boolean add(User st) {
        return list.add(st);
    }
    @Override
    public String toString() {
        return "Users [list=" + list + "]";
    }
}