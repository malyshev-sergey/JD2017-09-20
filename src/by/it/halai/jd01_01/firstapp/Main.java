package by.it.halai.jd01_01.firstapp;

/**
 * @author Vitaly Halai
 * @version 1.0
 *          Моя первая программа
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        //создание экземпляра класса
        MyFirstClass myFirstClass = new MyFirstClass();
        //используем методы созданного экземпляра
        myFirstClass.setSlogan("Hello World!");
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет Мир!");
        myFirstClass.printSlogan();
        //покажем аргументы
        new PrintArgs().showArgs(args);


    }
}
