package by.it.meshchenko.jd02_09;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
        "RoomName",
        "Square",
        "Price",
        "isRented"
})
public class Room {
    private String RoomName;
    private double Square;
    private double Price;
    private boolean isRented;

    public Room() {
    }

    public Room(String roomName, double square, double price, boolean isRented) {
        this.RoomName = roomName;
        this.Square = square;
        this.Price = price;
        this.isRented = isRented;
    }

    public String getRoomName() {
        return RoomName;
    }

    public double getSquare() {
        return Square;
    }

    public double getPrice() {
        return Price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRoomName(String roomName) {
        this.RoomName = roomName;
    }

    public void setSquare(double square) {
        this.Square = square;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return String.format("\n\t\t %-7s плошадь:%-5.1f   стоимость:%-5.1f   арендована:%-3s",
                RoomName, Square, Price, (isRented ? "да" : "нет"));
    }
}
