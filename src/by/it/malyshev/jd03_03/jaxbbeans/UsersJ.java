package by.it.malyshev.jd03_03.jaxbbeans;

import by.it.malyshev.jd03_03.beans.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "usersJ"
})
@XmlRootElement(name = "usersJ")
public class UsersJ {

    @XmlElement(name = "users", required = true)
    List<Users> usersJ=new ArrayList<>();

    public UsersJ() {
    }

    public UsersJ(List<Users> usersJ) {
        this.usersJ = usersJ;
    }

    public List<Users> getUsersJ() {
        return usersJ;
    }

    public void setUsersJ(List<Users> usersJ) {
        this.usersJ = usersJ;
    }
}

