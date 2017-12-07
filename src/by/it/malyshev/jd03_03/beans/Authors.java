package by.it.malyshev.jd03_03.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authors", propOrder = {
        "id",
        "name"
})
public class Authors {

    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "name", required = true)
    private String name;

    public Authors() {
    }

    public Authors(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Authors(String name) {
        this.id = 0;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors Authors = (by.it.malyshev.jd03_03.beans.Authors) o;

        if (id != Authors.id) return false;
        return name.equals(Authors.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
