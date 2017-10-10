package by.it.shishov.jd01_08;

/**
 * Created by Сергей on 10.10.2017.
 */
public class Fish extends Animal {
    private String species;
    private String type;

    Fish(String name, int age, String sex, String species, String type) {

        super(name, age, sex);
        this.species = species;
        this.type = type;

    }

    @Override
    public void bite() {
        System.out.print("\n" + name + " зачем-то кусает воду!");
    }

    @Override
    public void drink() {
        System.out.print("\n" + name + " пытается попить из аквариума.");
    }

    @Override
    public void eat() {
        System.out.print("\n" + name + " ест корм для рыбок.");
    }

    @Override
    public void move() {
        System.out.print("\n" + name + " усредно плавает в аквариуме.");
    }

    @Override
    public void play() {
        System.out.print("\n" + name + " играет с Вами через аквариум.");
    }

    @Override
    public void sleep() {
        System.out.print("\n" + name + " пытается уснуть.( Если лежит боком к верху, скорее всего уже не проснется =( )");
    }

    @Override
    public void talk() {
        System.out.print("\n" + name + " пытается издать звук в воде.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nТип рыбы: " + type + "\nВид : " + species;
    }
}
