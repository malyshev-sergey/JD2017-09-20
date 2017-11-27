package by.it.ali.jd02_08;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Stax или DOM?");
        String s = sc.nextLine();
        switch (s) {
            case ("Stax"):
                Stax.parsing();
                break;
            case ("DOM"):
                DOM.parser();
                break;
            default:
                System.out.println("Неверно выбран парсер");
                break;
        }
    }
}
