package by.it.malyshev.project.java.beans;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "authors", propOrder = {
//        "id",
//        "authorname"
//})
public class Authors {

//    @XmlElement(name = "id", required = true)
    private int id;
//    @XmlElement(name = "authorname", required = true)
    private String authorname;

    public Authors() {
    }

    public Authors(int id, String authorname) {
        this.id = id;
        this.authorname = authorname;
    }

    public Authors(String name) {
        this.id = 0;
        this.authorname = authorname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", authorname='" + authorname +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors Authors = (by.it.malyshev.project.java.beans.Authors) o;

        if (id != Authors.id) return false;
        return authorname.equals(Authors.authorname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorname.hashCode();
        return result;
    }
}
