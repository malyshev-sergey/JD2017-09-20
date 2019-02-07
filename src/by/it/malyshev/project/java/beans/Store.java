package by.it.malyshev.project.java.beans;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "store", propOrder = {
//        "id",
//        "quantity",
//        "books_Id"
//})
public class Store {

//    @XmlElement(name = "id", required = true)
    private int id;
//    @XmlElement(name = "quantity", required = true)
    private int quantity;
//    @XmlElement(name = "books_Id", required = true)
    private int books_Id;

    public Store() {
    }

    public Store(int id, int quantity, int books_Id) {
        this.id = id;
        this.quantity = quantity;
        this.books_Id = books_Id;
    }

    public Store(int quantity, int books_Id) {
        this.id = 0;
        this.quantity = quantity;
        this.books_Id = books_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", books_Id=" + books_Id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (id != store.id) return false;
        if (quantity != store.quantity) return false;
        return books_Id == store.books_Id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quantity;
        result = 31 * result + books_Id;
        return result;
    }
}
