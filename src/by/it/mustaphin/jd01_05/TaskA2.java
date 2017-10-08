package by.it.mustaphin.jd01_05;

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskA2 {

    void equation() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - (b / (log(pow(a, 2))));
        System.out.println(y);
    }

    void scannerEquation() {
        System.out.println("введите натуральное число");
        double a = new Scanner(System.in).nextDouble();
        System.out.println("введите ещё одно натуральное число");
        double b = new Scanner(System.in).nextDouble();
        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - (b / (log(pow(a, 2))));
        System.out.println(y);
    }

}
