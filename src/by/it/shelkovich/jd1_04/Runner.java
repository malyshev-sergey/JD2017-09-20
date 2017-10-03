package by.it.shelkovich.jd1_04;

public class Runner {
    public static void main(String[] args) {

        //Задание А
        System.out.println("Задание А.");
        TaskA.run();

        //Задание В
        System.out.println("\n\nЗадание B.");
        TaskB taskB = new TaskB();
        taskB.printSummary();

        //Задание С
        System.out.println("\n\nЗадание C.");
        TaskC.run();
    }
}
