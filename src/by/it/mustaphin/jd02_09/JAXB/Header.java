package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header", propOrder = {"value"})
public class Header {

    @XmlAttribute(required = true)
    private int headerNumber;

    @XmlValue
    private String value;

    public Header(int headerNumber, String value) {
        this.headerNumber = headerNumber;
        this.value = value;
    }

    public Header() {
    }

    public int getHeaderNumber() {
        return headerNumber;
    }

    public void setHeaderNumber(int headerNumber) {
        this.headerNumber = headerNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Header #" + headerNumber + " " + value;
    }
}
