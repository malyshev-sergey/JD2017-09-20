package by.it.malyshev.jd02_09.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Haplotype", propOrder = {
        "strMarkers",
        "snpMarkers"
})
public class Haplotype implements Serializable {

    @XmlElement(name = "STRmarkers", required = true)
    private STRmarkers strMarkers;
    @XmlElement(name = "SNPs", required = true)
    private String snpMarkers;

    public Haplotype() {
    }

    public Haplotype(STRmarkers strMarkers, String snpMarkers) {
        this.strMarkers = strMarkers;
        this.snpMarkers = snpMarkers;
    }

    public String getSNPmarkers() {
        return snpMarkers;
    }
    public void setSNPmarkers(String snpMarkers) {
        this.snpMarkers = snpMarkers;
    }
    public STRmarkers getSTRmarkers() { return strMarkers; }


    @Override
    public String toString() {
        return "\n\t\t\tHaplotype{" +
                "\n\t\t\t\tstrMarkers=" + strMarkers +
                ", \n\t\t\t\tsnps='" + snpMarkers + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Haplotype haplotype = (Haplotype) o;

        return (strMarkers != null ? strMarkers.equals(haplotype.strMarkers) :
                haplotype.strMarkers == null) && (snpMarkers != null ? snpMarkers.equals(haplotype.snpMarkers) : haplotype.snpMarkers == null);
    }

    @Override
    public int hashCode() {
        int result = strMarkers != null ? strMarkers.hashCode() : 0;
        result = 31 * result + (snpMarkers != null ? snpMarkers.hashCode() : 0);
        return result;
    }
}
