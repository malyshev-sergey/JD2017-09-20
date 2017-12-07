package by.it.malyshev.jd03_03.jaxbbeans;

import by.it.malyshev.jd03_03.beans.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ordersJ"
})
@XmlRootElement(name = "ordersJ")
public class OrdersJ {

    @XmlElement(name = "orders", required = true)
    List<Orders> ordersJ=new ArrayList<>();

    public OrdersJ() {
    }

    public OrdersJ(List<Orders> ordersJ) {
        this.ordersJ = ordersJ;
    }

    public List<Orders> getOrdersJ() {
        return ordersJ;
    }

    public void setOrdersJ(List<Orders> ordersJ) {
        this.ordersJ = ordersJ;
    }
}
