package by.it.halai.jd01_01.firstapp;

/**
 * Этот класс распечатывает слоган на консоль.
 * Слоган по умолчанию "Hello World"
 */

public class MyFirstClass {
    //объявление члена класса, который хранит содержимое слогана
    private String slogan = "Hello World";

    //метод установки нового значения слогана
    void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    //определение метода вывода на устройство
    //в данном случае на консоль
    void printSlogan() {
        System.out.println(this.slogan);
    }
}
