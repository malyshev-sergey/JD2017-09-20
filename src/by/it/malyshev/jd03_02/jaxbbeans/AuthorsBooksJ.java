package by.it.malyshev.jd03_02.jaxbbeans;

import by.it.malyshev.jd03_02.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "authorsBooksJ"
})
@XmlRootElement(name = "authorsBooksJ")
public class AuthorsBooksJ {

    @XmlElement(name = "authorsBooks", required = true)
    List<AuthorsBooks> authorsBooksJ=new ArrayList<>();

    public AuthorsBooksJ() {
    }

    public AuthorsBooksJ(List<AuthorsBooks> authorsBooksJ) {
        this.authorsBooksJ = authorsBooksJ;
    }

    public List<AuthorsBooks> getAuthorsBooksJ() {
        return authorsBooksJ;
    }

    public void setAuthorsBooksJ(List<AuthorsBooks> authorsBooksJ) {
        this.authorsBooksJ = authorsBooksJ;
    }
}