package by.it.halai.jd01_05;


import java.util.Scanner;

import static java.lang.Math.*;

public class TaskA {
    static void solveTaskA1() {

        double a = 756.13;
        double x = 0.3;
        double p1 = cos(pow(x * x + PI / 6, 5));
        double p2 = sqrt(x * pow(a, 3));
        double p3 = log(abs((a - 1.12 * x) / 4));
        double res = p1 - p2 - p3;
        System.out.println("c разбивкой выражения на части" + res);
        double res2 = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println("полным выражением" + res2);
    }

    static void solveTaskA2() {

        double a = 1.21;
        System.out.println("Введите b (0,371) (при вводе десятичного числа обязательно использовать запятую)");
        double b = new Scanner(System.in).nextDouble();
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1 / 3) + pow(a * b, 5) - b / (log(a * a));
        System.out.println("y = " + y);
    }

    static void solveTaskA3() {

        double x = 12.1;
        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("при a = %7.2f  f = %7.2g\n", a, f);
        }

    }
}
