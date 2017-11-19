package by.it.shishov.jd01_08;

/**
 * Created by Сергей on 10.10.2017.
 */
public class Runner {
    public static void main(String[] args) {

        Animal dusya = new Cat("Дуся", 5, "женский", "Белый", "Метис");
        dusya.bite();
        dusya.move();
        dusya.talk();
        System.out.println(dusya);

        Animal dorry = new Fish("Дорри", 3, "жеснкий", "Щука", "Пресноводные");
        dorry.sleep();
        dorry.move();
        dorry.eat();
        System.out.println(dorry);

        Animal kesha = new Parrot("Кеша", 1, "мужской", "Какаду", "Красный", "4 см");
        kesha.play();
        kesha.drink();
        kesha.move();
        System.out.println(kesha);

    }
}
