package by.it.mustaphin.jd01_02;

import java.util.Scanner;

public class Utils {

    static int[] getMas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите через пробел целочисленные значения");
        String line = sc.nextLine().trim();
        String strMas[] = line.split(" ");
        int[] intMas = new int[strMas.length];
        for (int j = 0; j < strMas.length; j++) {
            intMas[j] = Integer.parseInt(strMas[j]);
        }
        return intMas;
    }

    static int[] argsToIntArr(String[] args) {
        int[] mas = new int[args.length];
        return null;
    }

}
