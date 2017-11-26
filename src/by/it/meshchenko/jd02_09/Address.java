package by.it.meshchenko.jd02_09;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
        "Country",
        "City",
        "Street"
})
public class Address {
    @XmlElement(required = true)
    private String Country;
    @XmlElement(required = true)
    private String City;
    @XmlElement(required = true)
    private String Street;

    //конструкторы
    public Address() {// необходим для маршаллизации/демаршалиизации XML
    }

    public Address(String country, String city, String street) {
        this.Country = country;
        this.City = city;
        this.Street = street;
    }

    //getters
    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    //setters
    public void setCountry(String country) {
        this.Country = country;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    //вывод в строку
    public String toString() {
        return Country +", "+ City + ", " + Street;
    }
}
