package by.it.shelkovich.jd1_12;

public class Runner12 {
    public static void main(String[] args) {
        System.out.println("Часть А:\n");
        System.out.println("Задание 1");
        TaskA.part1();
        System.out.println("\nЗадание 2");
        TaskA.part2();
        System.out.println("\nЗадание 3");
        TaskA.part3();

        System.out.println("\n\nЧасть B:\n");
        System.out.println("Задание 1");
        TaskB.part1();
        System.out.println("\nЗадание 2");
        TaskB.part2(100000);

        System.out.println("\n\nЧасть C:\n");
        System.out.println("Задание 1");
        TaskC.Part1();
        System.out.println("\nЗадание 2");
        TaskC.Part2();
        System.out.println("\nЗадание 3");
        TaskC.Part3();

        //Throwable e = new Throwable();
    }
}
