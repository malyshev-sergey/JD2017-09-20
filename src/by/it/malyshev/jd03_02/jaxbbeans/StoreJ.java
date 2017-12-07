package by.it.malyshev.jd03_02.jaxbbeans;

import by.it.malyshev.jd03_02.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "storeJ"
})
@XmlRootElement(name = "storeJ")
public class StoreJ {

    @XmlElement(name = "store", required = true)
    List<Store> storeJ=new ArrayList<>();

    public StoreJ() {
    }

    public StoreJ(List<Store> storeJ) {
        this.storeJ = storeJ;
    }

    public List<Store> getStoreJ() {
        return storeJ;
    }

    public void setStoreJ(List<Store> storeJ) {
        this.storeJ = storeJ;
    }
}