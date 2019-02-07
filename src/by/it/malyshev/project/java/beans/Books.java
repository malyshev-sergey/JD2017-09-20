package by.it.malyshev.project.java.beans;


import java.math.BigDecimal;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "books", propOrder = {
//        "id",
//        "title",
//        "pubyear",
//        "isbn",
//        "img",
//        "price"
//})
public class Books {

//    @XmlElement(name = "id", required = true)
    private int id;
//    @XmlElement(name = "title", required = true)
    private String title;
//    @XmlElement(name = "pubyear", required = true)
    private int pubyear;
//    @XmlElement(name = "isbn", required = true)
    private String isbn;
//    @XmlElement(name = "img", required = true)
//    private String img;
//    @XmlElement(name = "price", required = true)
    private BigDecimal price;

    public Books() {
    }

    public Books(int id, String title, int pubyear, String isbn, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.pubyear = pubyear;
        this.isbn = isbn;
 //       this.img = img;
        this.price = price;
    }

    public Books(String title, int pubyear, String isbn, BigDecimal price) {
        this.id = 0;
        this.title = title;
        this.pubyear = pubyear;
        this.isbn = isbn;
//        this.img = img;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPubyear() {
        return pubyear;
    }

    public void setPubyear(int pubyear) {
        this.pubyear = pubyear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    public String getImg() {
//        return img;
//    }

//    public void setImg(String img) {
//        this.img = img;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pubyear=" + pubyear +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (pubyear != books.pubyear) return false;
        if (!title.equals(books.title)) return false;
        if (isbn != null ? !isbn.equals(books.isbn) : books.isbn != null) return false;
        return price != null ? price.equals(books.price) : books.price == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + pubyear;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}