package by.it.biazverkhi.jd01_01;
//подключение класса не требуется, т.к. класс main
// и класс MyFirstClass находятся в одной папке
public class Main {
    public static void main (String [] args) {
        // создаем экземпляр класса
        MyFirstClass myFirstClass=new MyFirstClass();
        // и используем два экземплярных метода
        myFirstClass.setSlogan("Hello, world123!");
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет, мир!!");
        myFirstClass.printSlogan();
        // покажем аргументы
        new PrintArgs().showArgs(args);
    }
}
