package by.it.shishov.jd01_08;

/**
 * Created by Сергей on 10.10.2017.
 */
public abstract class Animal implements IDomesticAnimal{
    String name;
    private int age;
    private String sex;

    public Animal(String name, int age, String sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public void bite() {
    }

    @Override
    public void drink() {
    }

    @Override
    public void eat() {
    }

    @Override
    public void move() {
    }

    @Override
    public void play() {
    }

    @Override
    public void sleep() {
    }

    @Override
    public void talk() {
    }

    @Override
    public String toString() {
        if(age == 1)
            return "\n\nИнформация о животном:\nИмя: " + name + "\nВозраст : " + age + " год";
        else if (age <= 4)
            return "\n\nИнформация о животном:\nИмя: " + name + "\nВозраст : " + age + " года";
        else
            return "\n\nИнформация о животном:\nИмя: " + name + "\nВозраст : " + age + " лет";

    }
}
