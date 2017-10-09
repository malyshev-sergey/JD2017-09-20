package by.it.akhmelev.jd01_08._01_dog;

public class Runner {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Pudel();
        Pudel dog3 = new Pudel();
        //Pudel dog4 = new Dog(); // ошибка компиляции
        dog1.doBark(5); // метод класса Dog
        dog2.doBark(2); // полиморфный метод класса Pudel
        if (dog3.checkLife()) // неполиморфный метод класса Pudel
            dog3.doBark(4); // полиморфный метод класса Pudel
        // dog2.checkLife(); // ошибка компиляции – неполиморфный метод
        ((Pudel) dog2).checkLife(); // ок
        ((Pudel) dog1).checkLife(); // ошибка времени выполнения
    }
}







