package by.it.malyshev.jd03_03.jaxbbeans;

import by.it.malyshev.jd03_03.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "authorsJ"
})
@XmlRootElement(name = "authorsJ")
public class AuthorsJ {

    @XmlElement(name = "authors", required = true)
    List<Authors> authorsJ=new ArrayList<>();

    public AuthorsJ() {
    }

    public AuthorsJ(List<Authors> authorsJ) {
        this.authorsJ = authorsJ;
    }

    public List<Authors> getAuthorsJ() {
        return authorsJ;
    }

    public void setAuthorsJ(List<Authors> authorsJ) {
        this.authorsJ = authorsJ;
    }
}
