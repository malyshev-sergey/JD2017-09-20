package by.it.halai.jd01_01.firstapp;

/**
 * этот класс позволяет распечатать аргументы программы
 */

public class PrintArgs {
    void showArgs(String[] args) {
        for (String s : args) {
            System.out.printf("Аргумент == %s%n", s);
        }
    }
}
