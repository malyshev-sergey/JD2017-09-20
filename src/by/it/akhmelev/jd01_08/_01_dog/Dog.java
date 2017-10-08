package by.it.akhmelev.jd01_08._01_dog;

class Dog {
    // поля, конструкторы, методы
    void doBark(int barkCount) {
        // реализация
        for (; barkCount > 0; barkCount--) System.out.print("bark ");
        System.out.println();
    }
}
