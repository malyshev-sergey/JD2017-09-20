package by.it.malyshev.jd02_09.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geocoord", propOrder = {
        "latitude",
        "longitude"
})
public class Geocoord implements Serializable {

    @XmlElement(name = "Latitude")
    private double latitude;
    @XmlElement(name = "Longitude")
    private double longitude;

    public Geocoord() {
    }

    public Geocoord(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString() {
        return "\n\t\t\tGeocoord{" +
                "\n\t\t\t\tlatitude=" + latitude +
                ", \n\t\t\t\tlongitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geocoord geocoord = (Geocoord) o;

        return Double.compare(geocoord.latitude, latitude) == 0 && Double.compare(geocoord.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


