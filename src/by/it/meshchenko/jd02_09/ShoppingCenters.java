package by.it.meshchenko.jd02_09;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="ShoppingCenters")
public class ShoppingCenters {

    @XmlElement(name="ShoppingCenter")
    private ArrayList<ShoppingCenter> list = new ArrayList<ShoppingCenter>();

    public ShoppingCenters() {
        super();
    }

    public void setList(ArrayList<ShoppingCenter> list) {
        this.list = list;
    }
    public boolean add(ShoppingCenter st) {
        return list.add(st);
    }

    @Override
    public String toString() {
        return "ShoppingCenters [list ShoppingCenter=" + list + "\n]";
    }
}
