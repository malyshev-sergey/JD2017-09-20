package by.it.Biazverkhi.jd01_01;

public class MyFirstClass {
    // объявление члена класса , который хранит содержимое слогана
    private  String slogan="Hello World";

    //метод установки нового слогана
    public void setSlogan(String slogan) {this.slogan=slogan;}

    //определение метода вывода слогана на устройство (в данном случае консоль)
    void printSlogan() {System.out.println(this.slogan);}
}
