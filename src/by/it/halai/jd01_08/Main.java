package by.it.halai.jd01_08;

/**
 * @author Vitaly Halai
 */
public class Main {

    public static void main(String[] args) {
        //Создадим Авианосец
        MilitaryShip ac = new AircraftCarrier();
        System.out.println(ac.showState()); //посмотрим статус корабля
        ac.movement();                      //отправили корабль в плавание)))
        System.out.println(ac.showState());
        ac.stop();                          //остановили корабль
        System.out.println(ac.showState());
        ac.engineOff();                     //выключили энергоустановку
        System.out.println(ac.showState());
        ac.engineOff();                     //включили энергоустановку
        System.out.println(ac.showState());
        ac.readinessOfShip();               //отправим корабль в сухой док на ремонт
        System.out.println(ac.showState());
        ac.readinessOfShip();               //вернем корабль в строй
        System.out.println(ac.showState());
        System.out.println(ac.armoryType());    //Вывели тип корабля
        System.out.println(ac.defenceType());   //вывели на консоль защиту корабля
        ac.typeOfEngine();                      //вывели на консоль тип энергоустановки


    }
}
