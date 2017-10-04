package by.it.shelkovich.jd1_06;

public class Runner {
    public static void main(String[] args) {
        System.out.println("\nЗадание А");
        TaskA.part1();
        TaskA.part2();

        System.out.println("\nЗадание В");
        TaskB.part1();
        TaskB.part2();

        System.out.println("\nЗадание С");
        TaskC.part1();
        System.out.println("Полторы минутки можно покурить...");
        TaskC.part2String();
        TaskC.part2StringBuilder();

    }
}
