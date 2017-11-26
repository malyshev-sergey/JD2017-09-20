package by.it.malyshev.jd02_09.manual;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", propOrder = {
        "name",
        "ancestor",
        "country",
        "geocoord",
        "haplotype"
})
public class Person implements Serializable {

    @XmlElement(name = "Name", required = true)
    private String name;
    @XmlElement(name = "Ancestor", required = true)
    private String ancestor;
    @XmlElement(name = "Country", required = true)
    private String country;
    @XmlElement(name = "Geocoord", required = true)
    private Geocoord geocoord;
    @XmlElement(name = "Haplotype", required = true)
    private Haplotype haplotype;
    @XmlAttribute(name = "kit", required = true)
    private String kit;

    public Person() {
    }

    public Person(String name, String ancestor, String country, Geocoord geocoord, Haplotype haplotype, String kit) {
        this.name = name;
        this.ancestor = ancestor;
        this.country = country;
        this.geocoord = geocoord;
        this.haplotype = haplotype;
        this.kit = kit;
    }

    public String getName() { return name; }
    public String getAncestor() { return ancestor; }
    public String getCountry() { return country; }
    public Geocoord getGeocoord() { return geocoord; }
    public Haplotype getHaplotype() { return haplotype; }
    public String getKit() { return kit; }

    public void setName(String name) { this.name = name; }
    public void setAncestor(String ancestor) { this.ancestor = ancestor; }
    public void setCountry(String country) { this.country = country; }
    public void setGeocoord(Geocoord geocoord) { this.geocoord = geocoord; }
    public void setHaplotype(Haplotype haplotype) { this.haplotype = haplotype; }
    public void setKit(String kit) { this.kit = kit; }

    @Override
    public String toString() {
        return "\n\tPerson{" +
                "\n\t\tkit='" + kit + '\'' +
                ", \n\t\tname='" + name + '\'' +
                ", \n\t\tancestor='" + ancestor + '\'' +
                ", \n\t\tcountry='" + country + '\'' +
                ", \n\t\tgeocoord=" + geocoord +
                ", \n\t\thaplotype=" + haplotype +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return (name != null ? name.equals(person.name) : person.name == null) &&
                (ancestor != null ? ancestor.equals(person.ancestor) : person.ancestor == null) &&
                (country != null ? country.equals(person.country) : person.country == null) &&
                (geocoord != null ? geocoord.equals(person.geocoord) : person.geocoord == null) &&
                (haplotype != null ? haplotype.equals(person.haplotype) : person.haplotype == null) &&
                (kit != null ? kit.equals(person.kit) : person.kit == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ancestor != null ? ancestor.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (geocoord != null ? geocoord.hashCode() : 0);
        result = 31 * result + (haplotype != null ? haplotype.hashCode() : 0);
        result = 31 * result + (kit != null ? kit.hashCode() : 0);
        return result;
    }
}
