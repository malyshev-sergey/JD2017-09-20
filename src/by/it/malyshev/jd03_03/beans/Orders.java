package by.it.malyshev.jd03_03.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orders", propOrder = {
        "id",
        "quantity",
        "users_Id",
        "books_Id"
})
public class Orders {

    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "quantity", required = true)
    private int quantity;
    @XmlElement(name = "users_Id", required = true)
    private int users_Id;
    @XmlElement(name = "books_Id", required = true)
    private int books_Id;

    public Orders() {
    }

    public Orders(int id, int quantity, int users_Id, int books_Id) {
        this.id = id;
        this.quantity = quantity;
        this.users_Id = users_Id;
        this.books_Id = books_Id;
    }

    public Orders(int quantity, int users_Id, int books_Id) {
        this.id = 0;
        this.quantity = quantity;
        this.users_Id = users_Id;
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

    public int getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(int users_Id) {
        this.users_Id = users_Id;
    }

    public int getBooks_Id() {
        return books_Id;
    }

    public void setBooks_Id(int books_Id) {
        this.books_Id = books_Id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", users_ID=" + users_Id +
                ", books_ID=" + books_Id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (quantity != orders.quantity) return false;
        if (users_Id != orders.users_Id) return false;
        return books_Id == orders.books_Id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quantity;
        result = 31 * result + users_Id;
        result = 31 * result + books_Id;
        return result;
    }
}
