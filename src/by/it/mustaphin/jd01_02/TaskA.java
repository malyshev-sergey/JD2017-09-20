package by.it.mustaphin.jd01_02;

import java.util.Scanner;

public class TaskA {

    void shortLong(int[] mas, boolean direction) {
        Integer value = mas[0];
        for (Integer i : mas) {
            if (direction) {
                if (value.toString().length() < i.toString().length()) {
                    value = i;
                }
            } else {
                if (value.toString().length() > i.toString().length()) {
                    value = i;
                }
            }
        }
        if (direction) {
            System.out.println("Максимально длинное число " + value + ". Его длина " + value.toString().length());
        } else {
            System.out.println("Минимально короткое число " + value + ". Его длина " + value.toString().length());
        }
    }

    void mediumAr(int[] mas) {
        int sum = 0;
        int length = mas.length;
        for (Integer i : mas) {
            sum += i;
        }
        int medium = sum / length;
        System.out.print("Числа меньшие среднего арифметического: ");
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < medium) {
                System.out.printf("[%-2d]=%-3d ", i, mas[i]);
            }
        }
    }

    void differentSymbolsOnly(int mas[]) {
        first_loop:
        for (int numb : mas) {
            char masChar[] = String.valueOf(numb).toCharArray();
            for (int j = 0; j < masChar.length; j++) {
                for (int k = 0; k < masChar.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (masChar[j] == masChar[k]) {
                        continue first_loop;
                    }
                    if (j == k - 1) {
                        System.out.println("Число состоящее из различных цифр " + numb);
                        return;
                    }
                }
            }
        }
        System.out.println("Чисел состоящих из различных цифр нет");
    }

}
