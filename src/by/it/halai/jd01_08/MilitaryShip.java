package by.it.halai.jd01_08;

/**
 * @author Vitaly Halai
 */
public abstract class MilitaryShip implements Ship {
    //зададим несколько состояний по умолчанию
    private boolean powerOn = true;     //включен ли двигатель корабля или нет
    private boolean readiness = false;   //на ремонте корабль или нет
    private boolean shipMovement = false;//идет ли корабль
    private boolean shipStop = true;   //стоит ли корабль

    @Override
    public boolean movement() {
        boolean result = shipMovement;
        shipMovement = true;
        shipStop = false;
        powerOn = true;
        readiness = false;
        return result;
    }

    @Override
    public boolean stop() {
        shipStop = true;
        powerOn = false;
        readiness = false;
        return shipStop;
    }

    @Override
    public boolean readinessOfShip() {
        readiness = !readiness;
        return readiness;
    }

    public boolean engineOff() {
        powerOn = !powerOn;
        return powerOn;
    }

    public String defenceType() {
        return "Система противоторпедной обороны";
    }

    public String armoryType() {
        return "Военный корабль тип:";
    }

    public abstract String showState();

    public boolean isShipMovement() {
        return shipMovement;
    }

    public boolean isShipStop() {
        return shipStop;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public boolean isReadiness() {
        return readiness;
    }

}
