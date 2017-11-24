package by.it.meshchenko.jd02_09;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Rooms {
    @XmlElement(name="Room")
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public Rooms() { super(); }

    public void setRooms(ArrayList<Room> room) {
            this.rooms = room;
        }
    public boolean add(Room r) {
            return rooms.add(r);
        }

    @Override
    public String toString() {
            return "Rooms [list Room=" + rooms + "\n\t]";
        }

}
