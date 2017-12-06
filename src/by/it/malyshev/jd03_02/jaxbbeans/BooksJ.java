package by.it.malyshev.jd03_02.jaxbbeans;

import by.it.malyshev.jd03_02.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "booksJ"
})
@XmlRootElement(name = "booksJ")
public class BooksJ {

    @XmlElement(name = "books", required = true)
    List<Books> booksJ=new ArrayList<>();

    public BooksJ() {
    }

    public BooksJ(List<Books> booksJ) {
        this.booksJ = booksJ;
    }

    public List<Books> getBooksJ() {
        return booksJ;
    }

    public void setBooksJ(List<Books> booksJ) {
        this.booksJ = booksJ;
    }
}

