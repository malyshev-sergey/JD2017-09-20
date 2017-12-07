package by.it.malyshev.jd03_03.jaxbbeans;

import by.it.malyshev.jd03_03.beans.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "rolesJ"
})
@XmlRootElement(name = "rolesJ")

public class RolesJ {


        @XmlElement(name = "roles", required = true)
        List<Roles> rolesJ=new ArrayList<>();

        public RolesJ() {
        }

        public RolesJ(List<Roles> rolesJ) {
            this.rolesJ = rolesJ;
        }

        public List<Roles> getRolesJ() {
            return rolesJ;
        }

        public void setRolesJ(List<Roles> rolesJ) {
            this.rolesJ = rolesJ;
        }

    @Override
    public String toString() {
        return "RolesJ{" +
                "rolesJ=" + rolesJ +
                '}';
    }
}

