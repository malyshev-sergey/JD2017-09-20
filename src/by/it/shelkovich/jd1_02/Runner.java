package by.it.shelkovich.jd1_02;

public class Runner {
    public static void main(String[] args) {

        System.out.println("Задание А. \nВведите несколько чисел через пробел:");
        TaskA taskA = new TaskA(Util.readLine());
        taskA.printLongestShortest();
        taskA.printLessThanAverage();
        taskA.printDiffDigitNumber();

        System.out.println("\n\nЗадание B.");
        TaskB.part1();
        TaskB.part2();
        TaskB.part3();
    }
}
