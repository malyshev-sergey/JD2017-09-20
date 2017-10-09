package by.it.shishov.jd01_01;

public class Main {

    public static void main(String[] args) {

        MyFirstClass myFirstObject = new MyFirstClass();
        myFirstObject.printSlogan();
        myFirstObject.setSlogan("Привет Мир!!!");
        myFirstObject.printSlogan();

        PrintArgs.showArgs(args);
    }
}
