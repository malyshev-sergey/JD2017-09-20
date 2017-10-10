package by.it.shishov.jd01_08;

/**
 * Created by Сергей on 10.10.2017.
 */
public class Cat extends Animal {
    private String colour;
    private String species;

    public Cat(String name, int age, String sex, String colour, String species) {
        super(name, age, sex);
        this.colour = colour;
        this.species = species;
    }

    @Override
    public void bite() {
        System.out.print("\n" + name + " делает Вам милый кусь!");
    }

    @Override
    public void drink() {
        System.out.print("\n" + name + " пьет воду.");
    }

    @Override
    public void eat() {
        System.out.print("\n" + name + " ест кошачий корм.");
    }

    @Override
    public void move() {
        System.out.print("\n" + name + " носится по дому, как сумасщедший.");
    }

    @Override
    public void play() {
        System.out.print("\n" + name + " играет с Вами.");
    }

    @Override
    public void sleep() {
        System.out.print("\n" + name + " уснул.");
    }

    @Override
    public void talk() {
        System.out.print("\n" + name + " громко мяукает.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nЦвет шерсти: " + colour + "\nПорода : " + species;
    }
}
