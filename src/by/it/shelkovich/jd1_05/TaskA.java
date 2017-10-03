package by.it.shelkovich.jd1_05;

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskA {
    static void part1() {
        System.out.println("\nЧасть 1");
        double a = 756.13;
        double x = 0.3;

        double first = cos(pow(x * x + PI / 6, 5));
        double second = sqrt(x * pow(a, 3));
        double third = log(abs((a - 1.12*x)/4));

        double result = first - second - third;
        double sameResult = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12*x)/4));
        System.out.printf("Результат расчёта выражения: %f\n", result);
        System.out.printf("Результат расчёта выражения, записанного одной строкой: %f\n", sameResult);
    }

    static void part2(){
        System.out.println("\nЧасть 2");
        System.out.println("Введите параметр а (1,21 по заданию):");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        //double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b, 2)) - pow(a + 1.5, 1/3) + a*pow(b, 5) - b/log(pow(a, 2));
        System.out.printf("Результат расчёта выражения: %f\n", y);
    }

    static void part3(){
        System.out.println("\nЧасть 3");
        double x = 12.1;
        for (double a = -5; a <= 12; a+=3.75) {
            double f = exp(a*x) - 3.45*a;
            System.out.printf("При а=%4.2f f=%-5.2g\n", a, f);
        }
    }
}
