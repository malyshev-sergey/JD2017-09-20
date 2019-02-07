package by.it.malyshev.project.java.beans;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "authorsBooks", propOrder = {
//        "id",
//        "authors_Id",
//        "books_Id"
//})
public class AuthorsBooks {

//    @XmlElement(name = "id", required = true)
    private int id;
//    @XmlElement(name = "authors_Id", required = true)
    private int authors_Id;
//    @XmlElement(name = "authorname", required = true)
//    @XmlElement(name = "books_Id", required = true)
    private int books_Id;
//    @XmlElement(name = "title", required = true)
//    @XmlElement(name = "pubyear", required = true)
//    @XmlElement(name = "isbn", required = true)
//    @XmlElement(name = "img", required = true)
//    @XmlElement(name = "price", required = true)

    private int position;

    public AuthorsBooks() {
    }

    public AuthorsBooks(int id, int authors_Id, int books_Id, int position) {
        this.id = id;
        this.authors_Id = authors_Id;
        this.books_Id = books_Id;
        this.position = position;
    }

    public AuthorsBooks(int authors_Id, int books_Id, int position) {
        this.id = 0;
        this.authors_Id = authors_Id;
        this.books_Id = books_Id;
        this.position = position;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthors_Id() {
        return authors_Id;
    }

    public void setAuthors_Id(int authors_Id) {
        this.authors_Id = authors_Id;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "AuthorsBooks{" +
                "id=" + id +
                ", authors_Id=" + authors_Id +
                ", books_Id=" + books_Id +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorsBooks that = (AuthorsBooks) o;

        if (id != that.id) return false;
        if (authors_Id != that.authors_Id) return false;
        if (books_Id != that.books_Id) return false;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authors_Id;
        result = 31 * result + books_Id;
        result = 31 * result + position;
        return result;
    }
}