package by.it.halai.jd01_08;

/**
 * @author Vitaly Halai
 */
public interface Ship {
    //создадим возможные действия с кораблем
    void typeOfEngine();      //тип двигателя

    boolean movement();         //идет ли корабль

    boolean stop();             //стоит ли корабль на якоре

    boolean readinessOfShip();  //спущен ли корабль на воду
}
