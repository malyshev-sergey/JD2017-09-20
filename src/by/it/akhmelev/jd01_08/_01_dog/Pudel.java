package by.it.akhmelev.jd01_08._01_dog;

public class Pudel extends Dog {
    // поля, конструкторы, методы
    boolean checkLife() { // собственный метод
        return true; // stub
    }
    @Override // аннотация указывает на полиморфную природу метода (для IDE)
    public void doBark(int barkCount) { // переопределенный метод
    // реализация
        System.out.println("Pudel bark "+barkCount);
    }
}

