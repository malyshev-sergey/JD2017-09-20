package by.it.mustaphin.jd02_09.JAXB;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Header", propOrder = {""})
public class Header {

    @XmlAttribute(required = true)
    private int headerNumber;

    @XmlValue
    private String value;
}
