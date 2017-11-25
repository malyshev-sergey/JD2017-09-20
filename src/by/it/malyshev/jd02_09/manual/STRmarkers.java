package by.it.malyshev.jd02_09.manual;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRmarkers", propOrder = {
        "dys393",
        "dys390",
        "dys19",
        "dys391",
        "dys385a",
        "dys385b",
        "dys426",
        "dys388",
        "dys439",
        "dys389i",
        "dys392",
        "dys389ii"
})
public class STRmarkers implements Serializable {

    @XmlElement(name = "DYS393", required = true)
    private int dys393;
    @XmlElement(name = "DYS390", required = true)
    private int dys390;
    @XmlElement(name = "DYS19", required = true)
    private int dys19;
    @XmlElement(name = "DYS391", required = true)
    private int dys391;
    @XmlElement(name = "DYS385a", required = true)
    private int dys385a;
    @XmlElement(name = "DYS385b", required = true)
    private int dys385b;
    @XmlElement(name = "DYS426", required = true)
    private int dys426;
    @XmlElement(name = "DYS388", required = true)
    private int dys388;
    @XmlElement(name = "DYS439", required = true)
    private int dys439;
    @XmlElement(name = "DYS389i", required = true)
    private int dys389i;
    @XmlElement(name = "DYS392", required = true)
    private int dys392;
    @XmlElement(name = "DYS389ii", required = true)
    private int dys389ii;

    public STRmarkers() {
    }

    public STRmarkers(int dys393, int dys390, int dys19, int dys391, int dys385a, int dys385b, int dys426, int dys388, int dys439, int dys389i, int dys392, int dys389ii) {
        this.dys393 = dys393;
        this.dys390 = dys390;
        this.dys19 = dys19;
        this.dys391 = dys391;
        this.dys385a = dys385a;
        this.dys385b = dys385b;
        this.dys426 = dys426;
        this.dys388 = dys388;
        this.dys439 = dys439;
        this.dys389i = dys389i;
        this.dys392 = dys392;
        this.dys389ii = dys389ii;
    }

    public int getDys393() { return dys393; }
    public int getDys390() { return dys390; }
    public int getDys19() { return dys19; }
    public int getDys391() { return dys391; }
    public int getDys385a() { return dys385a; }
    public int getDys385b() { return dys385b; }
    public int getDys426() { return dys426; }
    public int getDys388() { return dys388; }
    public int getDys439() { return dys439; }
    public int getDys389i() {return dys389i;}
    public int getDys392() { return dys392; }
    public int getDys389ii() { return dys389ii; }

    public void setDys393(int dys393) { this.dys393 = dys393; }
    public void setDys390(int dys390) { this.dys390 = dys390; }
    public void setDys19(int dys19) { this.dys19 = dys19; }
    public void setDys391(int dys391) { this.dys391 = dys391; }
    public void setDys385a(int dys385a) { this.dys385a = dys385a; }
    public void setDys385b(int dys385b) { this.dys385b = dys385b; }
    public void setDys426(int dys426) { this.dys426 = dys426; }
    public void setDys388(int dys388) { this.dys388 = dys388; }
    public void setDys439(int dys439) { this.dys439 = dys439; }
    public void setDys389i(int dys389i) { this.dys389i = dys389i; }
    public void setDys392(int dys392) { this.dys392 = dys392; }
    public void setDys389ii(int dys389ii) { this.dys389ii = dys389ii; }

    @Override
    public String toString() {
        return "\n\t\t\t\t\tSTRmarkers{" +
                "\n\t\t\t\t\t\tdys393=" + dys393 +
                ",\n\t\t\t\t\t\tdys390=" + dys390 +
                ",\n\t\t\t\t\t\tdys19=" + dys19 +
                ",\n\t\t\t\t\t\tdys391=" + dys391 +
                ",\n\t\t\t\t\t\tdys385a=" + dys385a +
                ",\n\t\t\t\t\t\tdys385b=" + dys385b +
                ",\n\t\t\t\t\t\tdys426=" + dys426 +
                ",\n\t\t\t\t\t\tdys388=" + dys388 +
                ",\n\t\t\t\t\t\tdys439=" + dys439 +
                ",\n\t\t\t\t\t\tdys389i=" + dys389i +
                ",\n\t\t\t\t\t\tdys392=" + dys392 +
                ",\n\t\t\t\t\t\tdys389ii=" + dys389ii +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        STRmarkers that = (STRmarkers) o;

        return dys393 == that.dys393 && dys390 == that.dys390 && dys19 == that.dys19 && dys391 == that.dys391 &&
                dys385a == that.dys385a && dys385b == that.dys385b && dys426 == that.dys426 && dys388 == that.dys388 &&
                dys439 == that.dys439 && dys389i == that.dys389i && dys392 == that.dys392 && dys389ii == that.dys389ii;
    }

    @Override
    public int hashCode() {
        int result = dys393;
        result = 31 * result + dys390;
        result = 31 * result + dys19;
        result = 31 * result + dys391;
        result = 31 * result + dys385a;
        result = 31 * result + dys385b;
        result = 31 * result + dys426;
        result = 31 * result + dys388;
        result = 31 * result + dys439;
        result = 31 * result + dys389i;
        result = 31 * result + dys392;
        result = 31 * result + dys389ii;
        return result;
    }
}
