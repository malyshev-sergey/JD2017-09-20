package by.it.likhanau.jd01_08;


public class Runner {
    public static void main(String[] args) {
       WarShip ship = new AircraftCarrier("War ship", "AircraftCarrier");
        System.out.println(ship);
        ship.addWeapons();
        ship.addWeapons("aircraft");
        ship.move();
        ship.startEngine();
        ship.move();
        ship.stop();
        ship.stopEngine();
        ship.makeSignal();
    }
}
