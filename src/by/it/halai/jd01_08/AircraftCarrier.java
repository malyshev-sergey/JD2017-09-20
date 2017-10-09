package by.it.halai.jd01_08;

/**
 * @author Vitaly Halai
 */
public class AircraftCarrier extends MilitaryShip {
    @Override
    public String armoryType() {
        return super.armoryType().concat(" Авианосец");
    }

    @Override
    public void typeOfEngine() {
        if (this.armoryType().endsWith("Авианосец")) {
            System.out.println("Атомная энергоустановка");
        } else {
            System.out.println("Это не Авианосец");
        }
    }

    @Override
    public String showState() {
        String state = "Корабль стоит на рейде";
        if (this.isShipMovement()) {
            state = "Корабль идет";
            if (this.isShipStop())
                state = "Корабль стоит на месте";
            if (this.isPowerOn())
                state = "Корабль дрейфует";
            if (this.isReadiness())
                state = "Корабль в сухом доке";
        }
        return state;
    }

    @Override
    public String defenceType() {
        return super.defenceType() + ", Система ПВО";
    }
}
