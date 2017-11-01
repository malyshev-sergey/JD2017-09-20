package by.it.likhanau.jd01_08;

/**
 * Created by NotePad.by on 22.10.2017.
 */
public abstract class WarShip implements Ship {

    private boolean isEngineOn;
    protected String typeOfShip;

    @Override
    public String toString() {
        return "Type of the ship is " + typeOfShip + ".\n";
    }

    public WarShip(String typeOfShip) {
        this.typeOfShip = typeOfShip;
    }

    @Override
    public void stop() {
        System.out.println("The " + typeOfShip + " is stopped!");
    }

    @Override
    public void move() {
        if (isEngineOn) {
            System.out.println("The " + typeOfShip + " is moving!");
        } else {
            System.out.println("Please, start the engine first!");
        }
    }

    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println("The engine is started!");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        System.out.println("The engine is stopped!");
    }

   public void addWeapons(){
       System.out.println("Added some weapons!");
   }

    public void addWeapons(String weapon){
        System.out.println("Added some " + weapon + "!");
    }

    @Override
    public void makeSignal(){
        System.out.println("Tu-tuuuuu!");
    }
}
