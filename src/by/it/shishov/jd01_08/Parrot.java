package by.it.shishov.jd01_08;

/**
 * Created by Сергей on 10.10.2017.
 */
public class Parrot extends Animal {

    private String species;
    private String color;
    private String beakLength;

    Parrot(String name, int age, String sex, String species, String color, String beakLength) {
        super(name, age, sex);
        this.species = species;
        this.color = color;
        this.beakLength = beakLength;
    }

    @Override
    public void bite() {
        System.out.print("\n" + name + " больно кусает Вас за палец.");
    }

    @Override
    public void drink() {
        System.out.print("\n" + name + " пьет из вашего стакана.");
    }

    @Override
    public void eat() {
        System.out.print("\n" + name + " ест свой корм для попугаев.");
    }

    @Override
    public void move() {
        System.out.print("\n" + name + " летает по всему дому.");
    }

    @Override
    public void play() {
        System.out.print("\n" + name + " играет с Вами в догонялки.");
    }

    @Override
    public void sleep() {
        System.out.print("\n" + name + " улетел спать.");
    }

    @Override
    public void talk() {
        System.out.print("\n" + name + " пытается спародировать Ваш голос");
    }

    @Override
    public String toString() {
        return super.toString() + "\nОкрас попугая : " + color + "\nВид : " + species + "\nДлина клюва : " + beakLength;
    }
}
