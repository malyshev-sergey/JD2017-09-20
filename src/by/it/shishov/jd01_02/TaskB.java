package by.it.shishov.jd01_02;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by Сергей on 02.10.2017.
 */
public class TaskB {
    public static void printArr(int k) {
        int col = 0;
        System.out.println("Вывод чисел от 1 до " + k);
        for (int i = 1; i <= k; i++) {
            System.out.printf("%-9d", i, i);
            col++;
            if ((col % Math.round(Math.sqrt(k)) == 0)) {
                System.out.println();
            }

        }
    }

    public static void quadraticEquation() {
        double d, root1, root2;
        System.out.println("Введите а: ");
        double a = new Scanner(System.in).nextDouble();
        System.out.println("Введите b: ");
        double b = new Scanner(System.in).nextDouble();
        System.out.println("Введите c: ");
        double c = new Scanner(System.in).nextDouble();

        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
        d = pow(b, 2) - 4 * a * c;
        System.out.println("D = " + d);
        if (d > 0) {
            root1 = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
            root2 = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
            System.out.println("Первый корень = " + root1 + "\n" + "Второй корень = " + root2);
        } else if (d == 0) {
            root1 = (-b) / (2 * a);
            System.out.println("Корень = " + root1);
        } else {
            System.out.println("Нет корней");
        }
    }

    static void monthCase() {
        System.out.println("\n Введите номер месяца: ");
        int month = new Scanner(System.in).nextInt();
        switch (month) {
            case 1: {
                System.out.println("Январь");
                break;
            }
            case 2: {
                System.out.println("Февраль");
                break;
            }
            case 3: {
                System.out.println("Март");
                break;
            }
            case 4: {
                System.out.println("Апрель");
                break;
            }
            case 5: {
                System.out.println("Май");
                break;
            }
            case 6: {
                System.out.println("Июнь");
                break;
            }
            case 7: {
                System.out.println("Июль");
                break;
            }
            case 8: {
                System.out.println("Август");
                break;
            }
            case 9: {
                System.out.println("Сентябрь");
                break;
            }
            case 10: {
                System.out.println("Октябрь");
                break;
            }
            case 11: {
                System.out.println("Ноябрь");
                break;
            }
            case 12: {
                System.out.println("Декабрь");
                break;
            }
            default: {
                System.out.println("Нет такого номера месяца");
            }
        }
    }
}

