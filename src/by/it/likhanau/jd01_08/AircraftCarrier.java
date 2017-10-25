package by.it.likhanau.jd01_08;

/**
 * Created by NotePad.by on 22.10.2017.
 */
public class AircraftCarrier extends WarShip {

    private String typeOfShip;

    @Override
    public String toString() {
        return super.toString() + "Type of the warship is " + typeOfShip + ".\n";
    }

    public AircraftCarrier(String typeOfShip, String typeOfShip1) {
        super(typeOfShip);
        this.typeOfShip = typeOfShip1;
        }

    @Override
    public void stop() {
        System.out.println("The " + super.typeOfShip + " " + typeOfShip + " is stopped!");
    }

    @Override
    public void move() {
        System.out.print(typeOfShip + ". ");
        super.move();
    }

    @Override
    public void makeSignal(){
        System.out.println("Du-du-du-Doooooo!");
    }
}
