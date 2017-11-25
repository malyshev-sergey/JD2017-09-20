package by.it.malyshev.jd02_09.manual;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "persons"
})
@XmlRootElement(name = "Gendata")
public class Gendata implements Serializable {


    @XmlElement(name = "Person", required = true)
    private ArrayList<Person> persons=new ArrayList<>();

    public Gendata() {
        super();
    }

    public void setPerson(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public boolean add(Person person) {
        return persons.add(person);
    }

    @Override
    public String toString() {
        return "Gendata{" +
                "persons=" + persons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gendata gendata = (Gendata) o;

        return persons != null ? persons.equals(gendata.persons) : gendata.persons == null;
    }

    @Override
    public int hashCode() {
        return persons != null ? persons.hashCode() : 0;
    }
}
