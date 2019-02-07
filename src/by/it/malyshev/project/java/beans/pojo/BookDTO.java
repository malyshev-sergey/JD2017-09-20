package by.it.malyshev.project.java.beans.pojo;

import java.math.BigDecimal;
import java.util.List;

public class BookDTO {

    private int id;
    private String title;
    private int pubyear;
    private String isbn;
    private BigDecimal price;
    private List<String> authors;
    private int quantity;

    public BookDTO(int id, String title, int pubyear, String isbn, BigDecimal price, List<String> authors, int quantity) {
        this.id = id;
        this.title = title;
        this.pubyear = pubyear;
        this.isbn = isbn;
        this.price = price;
        this.authors = authors;
        this.quantity = quantity;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pubyear=" + pubyear +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                ", quantity=" + quantity +
                '}';
    }
}
