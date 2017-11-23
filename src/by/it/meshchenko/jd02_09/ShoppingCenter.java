package by.it.meshchenko.jd02_09;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "ShoppingCenter", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "Name",                           // PUBLIC_MEMBER - только public
        "Address",                       // NONE - ни одно
        "Lat",
        "Lng",
        "Rooms"
})
public class ShoppingCenter {
    @XmlElement(required = true)
    private String Name;
    @XmlElement(required = true)
    private Address Address = new Address();
    @XmlElement(required = true)
    private double Lat;
    @XmlElement(required = true)
    private double Lng;
    @XmlElement(required = true)
    private Rooms Rooms = new Rooms();
//    @XmlElement(name="Rooms")
//    private ArrayList<Room> Rooms = new ArrayList<Room>();

    public ShoppingCenter() {
    } // необходим для маршаллизации/демаршалиизации XML

    public ShoppingCenter(String name, Address address, double lat, double lng, Rooms rooms) {
        this.Name = name;
        this.Address = address;
        this.Lat = lat;
        this.Lng = lng;
        this.Rooms = rooms;
    }

    //getters
    public String getName() {
        return Name;
    }

    public Address getAddress() {
        return Address;
    }

    public double getLat() {
        return Lat;
    }

    public double getLng() {
        return Lng;
    }

    public Rooms getRooms() {
        return Rooms;
    }

    //setters
    public void setName(String name) {
        this.Name = name;
    }

    public void setAddress(Address address) {
        this.Address = address;
    }

    public void setLat(double lat) {
        this.Lat = lat;
    }

    public void setLng(double lng) {
        this.Lng = lng;
    }

    public void setRooms(Rooms rooms) {
        this.Rooms = rooms;
    }
    public boolean addRoom(Room r){
        return this.Rooms.add(r);
    }

    //вывод в строку
    public String toString() {
        return "\n\tName: " + Name + "\n\tAdress : " + Address + "\n\tLat,Lng :"
                + Lat + "," + Lng + "\n\t" + Rooms.toString();
    }
}
