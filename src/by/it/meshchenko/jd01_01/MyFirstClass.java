package by.it.meshchenko.jd01_01;

public class MyFirstClass {
    //Член класса, который хранит содержимое слогана
    private String slogan = "Hello, world!";

    //Метод, который устанавливает содержимое слогана
    public void setSlogan(String slogan) {this.slogan = slogan;}

    //Метод вывода слогана на устройство (в данном случае консоль)
    void printSloagan() {System.out.println(this.slogan);}
}
