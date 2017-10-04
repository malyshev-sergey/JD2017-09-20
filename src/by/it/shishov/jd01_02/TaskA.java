package by.it.shishov.jd01_02;

import java.util.Scanner;

/**
 * Created by Сергей on 26.09.2017.
 */
class TaskA {

    static String getMyLine() {

        System.out.println("Введите строку:");
        String line = new Scanner(System.in).nextLine();
        return line;
    }

    static int[] ParseLine(String line) {

        String[] strMas = line.split("\\D");
        int[] intMas = new int[strMas.length];

        System.out.println("Преобразованная строка:");
        for (int i = 0; i < strMas.length; i++) {
            intMas[i] = Integer.parseInt(strMas[i]);
            System.out.print(intMas[i] + " ");
        }
        return intMas;

    }

    public static void getMaxValue(int[] intMas) {

        int max = intMas[0];

        for (int i = 0; i < intMas.length; i++) {
            if (String.valueOf(max).length() < String.valueOf(intMas[i]).length()) {
                max = intMas[i];
            }
        }
        System.out.println("\n" + "Самый длинный элемент - это " + max + ", его длина равна " + String.valueOf(max).length() + " символу/ам.");

    }

    static void getMinValue(int[] intMas) {

        int min = intMas[intMas.length - 1];

        for (int i = 0, j = 0; i < intMas.length; i++) {
            if (String.valueOf(min).length() > String.valueOf(intMas[i]).length()) {
                min = intMas[i];
            }
        }
        System.out.println("\n" + "Самый короткий элемент - это " + min + ", его длина равна " + String.valueOf(min).length() + " символу/ам.");

    }

    static void showNumbersBelowAverage(int[] intMas) {

        double average = 0, result;

        for (int i = 0; i < intMas.length; i++) {
            average += intMas[i];
        }
        result = average / (intMas.length);
        System.out.println("\n" + "Следующие числа являются меньше среднего арифметического: ");
        for (int i = 0; i < intMas.length; i++) {
            if (intMas[i] < result)
                System.out.print(intMas[i] + " ");
        }
    }

    static void checkUniqueDigits(int[] intMas) {

        boolean flag = false;

        for (int i = 0; i < intMas.length; i++) {
            char[] digit = String.valueOf(intMas[i]).toCharArray();
            for (int j = 0; j < digit.length - 1; j++) {
                if (digit.length != 1) {
                    if (digit[j] == digit[j + 1]) {
                        flag = true;
                        System.out.println("\n" + "Число с одинаковыми цифрами - это " + intMas[i]);
                        break;
                    }
                }
            }
        }
        if (!flag)
            System.out.println("\n" + "Нет чисел с одинаковыми цифрами");
    }
}
