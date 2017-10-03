package by.it.meshchenko.jd01_01;

public class Main {

    public static void main(String[] args) {
	    //Создание экземпляра класса
        MyFirstClass myFirstClass = new MyFirstClass();

        //Используем два экземпляра метода
        myFirstClass.setSlogan("Hello, world!");
        myFirstClass.printSloagan();
        myFirstClass.setSlogan("Привет, мир!");
        myFirstClass.printSloagan();

        new PrintArgs().showArgs(args);
    }
}
